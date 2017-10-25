/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.care.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.model.CareDetail;
import sch.pl.graduate.recommendation.care.model.CareReview;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Repository
@Mapper
public interface CareMapper {
    Integer addCare(Care care);

    List<Caretaker> getCaretakersFromCareLog(User currentUser);

    List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(
            @Param("consignerKey") Long consignerKey,
            @Param("caretakerKey") Long caretakerKey);

    Integer addCareDetails(List<CareDetail> careDetails);

    Integer addCareReview(CareReview careReview);

    List<CareReview> getCareReviewsByCaretakerKey(Long caretakerKey);

    List<Care> getCaresByCaretakerKey(Long caretakerKey);
}
