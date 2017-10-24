package sch.pl.graduate.recommendation.user.consigner.service;

import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.model.RecommendationDataForConsigner;

import java.util.List;

/**
 * Created by taesu on 2017-10-21.
 */
public interface ConsignerService {

    List<Caretaker> getUsersForConsigner(UserCriteria userCriteria);

    Integer getUsersForConsignerTotalCount(UserCriteria userCriteria);

    Caretaker getUserForConsigner(Long userKey);

    List<Caretaker> getRecommendedCaretakers();

    List<Caretaker> getRecommendedCaretakersFromRequestData(RecommendationDataForConsigner recommendationDataForConsigner);

    List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(Long caretakerKey);
}
