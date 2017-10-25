/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.care.service;

import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.model.CareReview;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
public interface CareService {
    Integer addCare(Care care);

    Integer addCareReview(CareReview careReview);

    List<Caretaker> getCaretakersFromCareLog();

    List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(Long consignerKey, Long caretakerKey);

    List<CareReview> getCareReviewsByCaretakerKey(Long caretakerKey);

    List<Care> getCaresByCaretakerKey(Long caretakerKey);
}
