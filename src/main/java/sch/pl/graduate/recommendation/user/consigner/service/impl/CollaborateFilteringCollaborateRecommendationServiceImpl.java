/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.consigner.mapper.RecommendationMapper;
import sch.pl.graduate.recommendation.user.consigner.model.CaretakerColumn;
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;
import sch.pl.graduate.recommendation.user.consigner.model.ExpectedScore;
import sch.pl.graduate.recommendation.user.consigner.service.CollaborateRecommendationService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
@Service
public class CollaborateFilteringCollaborateRecommendationServiceImpl extends AbstractService implements CollaborateRecommendationService {

    private final RecommendationMapper recommendationMapper;

    @Autowired
    public CollaborateFilteringCollaborateRecommendationServiceImpl(RecommendationMapper recommendationMapper) {
        this.recommendationMapper = recommendationMapper;
    }

    /**
     * 다음 공식하에 유사도를 계산한다
     * <p>
     * roof
     * sum (Rai - Ra) * (Rbi - Rb)
     * -------------------------------------------
     * sqrt( sum ((Rai - Ra)^2) *  sum ((Rbi - Rb)^2) )
     *
     * @param currentUserRow
     * @param otherUserRow
     * @return
     */
    @Override
    public Double getSimilarity(ConsignerWithCaretakerMatrix currentUserRow, ConsignerWithCaretakerMatrix otherUserRow) {
        Double currentUserAvg = currentUserRow.getAvg();        //Ra
        Double otherUserAvg = otherUserRow.getAvg();            //Rb

        if(currentUserAvg == null || otherUserAvg == null) {
            return 0D;
        }

        Double upper = 0D;
        Double lower = 0D;

        Double lowerLeft = 0D;
        Double lowerRight = 0D;

        List<CaretakerColumn> currentUserScores = currentUserRow.getCaretakerColumns();
        List<CaretakerColumn> otherUserScores = otherUserRow.getCaretakerColumns();
        for(int i = 0; i < currentUserScores.size(); i++) {
            Double currentUserScore = currentUserScores.get(i).getScore();       //Rai
            Double otherUserScore = otherUserScores.get(i).getScore();           //Rbi

            if(currentUserScore == null || otherUserScore == null) {
                continue;
            }

            //(Rai - Ra) * (Rbi - Rb)
            Double calc = (currentUserScore - currentUserAvg) * (otherUserScore - otherUserAvg);
            calc = getValidatedZeroValue(calc);     //값이 0이 되는경우 (avg와 score가 동일한 경우) 계산값이 0이 되는 것 방지
            upper += calc;

            // (Rai - Ra)^2
            calc = (currentUserScore - currentUserAvg) * (currentUserScore - currentUserAvg);
            calc = getValidatedZeroValue(calc);
            lowerLeft += calc;

            // (Rbi - Rb)^2
            calc = (otherUserScore - otherUserAvg) * (otherUserScore - otherUserAvg);
            calc = getValidatedZeroValue(calc);
            lowerRight += calc;
        }

        lower = lowerLeft * lowerRight;
        lower = getValidatedZeroValue(lower);
        return upper / Math.sqrt(lower);
    }

    private Double getValidatedZeroValue(Double value) {
        return value.equals(0D) ? 0.00001D : value;
    }

    //계산
    @Override
    public List<Caretaker> recommendByPreviousLog(List<Caretaker> previousLog) {
        List<ConsignerWithCaretakerMatrix> matrices = getConsignerAndCaretakerMatrix();
        List<ExpectedScore> topNUsers = extractTopNCaretakerKeysByScore(matrices, 5L);

        User currentUser = getCurrentUser();
        return recommendationMapper.getRecommendedCaretakerFromTopNExpectedScores(currentUser.getUserKey(), topNUsers, 5);
    }

    @Override
    @Deprecated
    public List<ConsignerWithCaretakerMatrix> getConsignerAndCaretakerMatrix() {
        User currentUser = getCurrentUser();
        List<ConsignerWithCaretakerMatrix> matrix = recommendationMapper.getConsignerAndCaretakerMatrix(currentUser.getUserKey());


        ConsignerWithCaretakerMatrix currentUserRow = getCurrentConsignerRow(matrix);
        for(ConsignerWithCaretakerMatrix row : matrix) {
            Double similarity = getSimilarity(currentUserRow, row);
            row.setSimilarity(similarity);

            List<ExpectedScore> expectedScores = getExpectedScore(currentUserRow, row);
            row.setExpectedScores(expectedScores);
        }
        return matrix;
    }

    private ConsignerWithCaretakerMatrix getCurrentConsignerRow(List<ConsignerWithCaretakerMatrix> matrix) {
        for(ConsignerWithCaretakerMatrix row : matrix) {
            if(row.getIsCurrentUser()) {
                return row;
            }
        }
        throw new SystemException("현재 사용자의 정보를 담은 ROW가 반환되지 않음");
    }

    private List<ExpectedScore> extractTopNCaretakerKeysByScore(List<ConsignerWithCaretakerMatrix> matrices, Long N) {
        User currentUser = getCurrentUser();
        List<ExpectedScore> expectedScores = new ArrayList<>();
        for(ConsignerWithCaretakerMatrix matrix : matrices) {
            if(!currentUser.getUserKey().equals(matrix.getConsignerKey())) {
                expectedScores.addAll(matrix.getExpectedScores());
            }
        }

        expectedScores = expectedScores
                .stream()
                .sorted(Comparator.comparingDouble(ExpectedScore::getScore).reversed())
                .filter(distinctByKey(ExpectedScore::getCaretakerKey))
                .limit(N)
                .collect(Collectors.toList());

        return expectedScores;
    }

    private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    @Override
    public List<ExpectedScore> getExpectedScore(ConsignerWithCaretakerMatrix currentUserRow, ConsignerWithCaretakerMatrix otherUserRow) {
        List<ExpectedScore> expectedScores = new ArrayList<>();
        List<CaretakerColumn> columns = otherUserRow.getCaretakerColumns();
        List<CaretakerColumn> currentUserColumns = currentUserRow.getCaretakerColumns();

        final Double currentUserAvg = currentUserRow.getAvg();
        final Double similarity = otherUserRow.getSimilarity();      //유사도
        for(int i = 0; i < columns.size(); i++) {
            CaretakerColumn column = columns.get(i);

            if(currentUserColumns.get(i).getScore() != null) {   //이미 구매 이력이 있는 경우 제외
                expectedScores.add(new ExpectedScore(column.getCaretakerKey(), -1D));
                continue;
            }

            Double scoreOfOtherUser = column.getScore();
            Double otherUserAvg = otherUserRow.getAvg();

            if(similarity.equals(0D)) {
                expectedScores.add(new ExpectedScore(column.getCaretakerKey(), 0D));
                continue;
            }

            if(scoreOfOtherUser != null) {
                Double expectedScore = calcurlateExpectedScore(currentUserAvg, similarity, scoreOfOtherUser, otherUserAvg);
                expectedScores.add(new ExpectedScore(column.getCaretakerKey(), expectedScore));
            } else {
                expectedScores.add(new ExpectedScore(column.getCaretakerKey(), 0D));
            }
        }

        return expectedScores;
    }

    private Double calcurlateExpectedScore(Double currentUserAvg, Double similarity, Double scoreOfOtherUser, Double otherUserAvg) {
        return currentUserAvg + ((similarity * (scoreOfOtherUser - otherUserAvg)) / Math.abs(similarity));
    }
}
