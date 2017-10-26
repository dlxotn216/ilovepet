package sch.pl.graduate.recommendation.user.consigner.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.service.CareService;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.mapper.ConsignerMapper;
import sch.pl.graduate.recommendation.user.consigner.model.CaretakerColumn;
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;
import sch.pl.graduate.recommendation.user.consigner.model.RecommendationDataForConsigner;
import sch.pl.graduate.recommendation.user.consigner.service.ConsignerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taesu on 2017-10-21.
 */
@Service
public class ConsignerServiceImpl extends AbstractService implements ConsignerService {

    private static final Logger log = LoggerFactory.getLogger(ConsignerServiceImpl.class);

    @Autowired
    private CareService careService;

    @Autowired
    private ConsignerMapper consignerMapper;

    @Override
    public Integer getUsersForConsignerTotalCount(UserCriteria userCriteria) {
        return consignerMapper.getUsersForConsignerTotalCount(userCriteria);
    }

    @Override
    public List<Caretaker> getUsersForConsigner(UserCriteria userCriteria) {
        return consignerMapper.getUsersForConsigner(userCriteria);
    }

    @Override
    public Caretaker getUserForConsigner(Long userKey) {
        return consignerMapper.getUserForConsigner(userKey);
    }

    @Override
    public List<Caretaker> getRecommendedCaretakers() {
        List<Caretaker> caretakersFromLog = careService.getCaretakersFromCareLog();

        if(recommendationDataIsEnough(caretakersFromLog)) {
            return recommendByPreviousLog(caretakersFromLog);
        } else {
            return null;
        }
    }

    private Boolean recommendationDataIsEnough(List<Caretaker> caretakersFromLog) {
        return !CollectionUtils.isEmpty(caretakersFromLog);
    }

    //계산
    private List<Caretaker> recommendByPreviousLog(List<Caretaker> previousLog) {
        User currentUser = getCurrentUser();
        List<ConsignerWithCaretakerMatrix> matrix = consignerMapper.getConsignerAndCaretakerMatrix(currentUser.getUserKey());
        return consignerMapper.getUsersForConsigner(new UserCriteria());
    }

    @Override
    @Deprecated
    public List<ConsignerWithCaretakerMatrix> getConsignerAndCaretakerMatrix() {
        User currentUser = getCurrentUser();
        List<ConsignerWithCaretakerMatrix> matrix = consignerMapper.getConsignerAndCaretakerMatrix(currentUser.getUserKey());


        ConsignerWithCaretakerMatrix currentUserRow = getCurrentConsignerRow(matrix);
        for(ConsignerWithCaretakerMatrix row : matrix) {
            Double similarity = getSimilarity(currentUserRow, row);
            row.setSimilarity(similarity);

            List<Double> expectedScores = getExpectedScore(currentUserRow, row);
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
    private Double getSimilarity(ConsignerWithCaretakerMatrix currentUserRow, ConsignerWithCaretakerMatrix otherUserRow) {
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
                break;
            }

            //(Rai - Ra) * (Rbi - Rb)
            Double calc = (currentUserScore - currentUserAvg) * (otherUserScore - otherUserAvg);
            upper += calc;

            // (Rai - Ra)^2
            calc = (currentUserScore - currentUserAvg) * (currentUserScore - currentUserAvg);
            lowerLeft += calc;

            // (Rbi - Rb)^2
            calc = (otherUserScore - otherUserAvg) * (otherUserScore - otherUserAvg);
            lowerRight += calc;
        }

        lower = lowerLeft * lowerRight;
        return upper / Math.sqrt(lower);
    }

    private List<Double> getExpectedScore(ConsignerWithCaretakerMatrix currentUserRow, ConsignerWithCaretakerMatrix otherUserRow) {
        List<Double> expectedScores = new ArrayList<>();
        List<CaretakerColumn> columns = otherUserRow.getCaretakerColumns();

        final Double currentUserAvg = currentUserRow.getAvg();
        final Double similarity = otherUserRow.getSimilarity();      //유사도
        for(CaretakerColumn column : columns) {
            Double scoreOfOtherUser = column.getScore();
            Double otherUserAvg = otherUserRow.getAvg();

            if(scoreOfOtherUser != null) {
                Double expectedScore = calcurlateExpectedScore(currentUserAvg, similarity, scoreOfOtherUser, otherUserAvg);
                expectedScores.add(expectedScore);
            } else {
                expectedScores.add(0D);
            }
        }

        return expectedScores;
    }

    private Double calcurlateExpectedScore(Double currentUserAvg, Double similarity, Double scoreOfOtherUser, Double otherUserAvg) {
        return currentUserAvg + ((similarity * (scoreOfOtherUser - otherUserAvg)) / Math.abs(similarity));
    }

    @Override
    public List<Caretaker> getRecommendedCaretakersFromRequestData(RecommendationDataForConsigner recommendationDataForConsigner) {
        return consignerMapper.getUsersForConsigner(new UserCriteria());
    }

    @Override
    public List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(Long caretakerKey) {
        User currentUser = getCurrentUser();
        Long consignerKey = currentUser.getUserKey();
        return careService.getCareLogsByCaretakerKeyAndWithoutAddCareReview(consignerKey, caretakerKey);
    }

}
