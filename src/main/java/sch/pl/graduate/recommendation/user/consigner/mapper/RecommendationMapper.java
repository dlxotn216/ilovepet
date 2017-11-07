/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;
import sch.pl.graduate.recommendation.user.consigner.model.ExpectedScore;
import sch.pl.graduate.recommendation.user.consigner.model.UserProfileForContentBasedRecommendation;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
@Repository
@Mapper
public interface RecommendationMapper {
    List<UserProfileForContentBasedRecommendation> getWeightTable(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation);

    List<ConsignerWithCaretakerMatrix> getConsignerAndCaretakerMatrix(Long consignerKey);

    List<Caretaker> getRecommendedCaretakerFromTopNExpectedScores(
            @Param("currentUserKey") Long currentUserKey,
            @Param("list") List<ExpectedScore> expectedScores,
            @Param("top") Integer top);
}
