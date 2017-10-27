package sch.pl.graduate.recommendation.user.consigner.service;

import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;
import sch.pl.graduate.recommendation.user.consigner.model.RecommendationDataForConsigner;
import sch.pl.graduate.recommendation.user.consigner.model.UserProfileForContentBasedRecommendation;

import java.util.List;

/**
 * Created by taesu on 2017-10-21.
 */
public interface ConsignerService {

    List<Caretaker> getUsersForConsigner(UserCriteria userCriteria);

    Integer getUsersForConsignerTotalCount(UserCriteria userCriteria);

    Caretaker getUserForConsigner(Long userKey);

    List<Caretaker> getRecommendedCaretakersByCollaborateFiltering();

    List<ConsignerWithCaretakerMatrix> getConsignerAndCaretakerMatrix();

    List<? extends Caretaker> getRecommendedCaretakersByContentBasedRecommendation(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation);

    List<Caretaker> getRecommendedCaretakersFromRequestData(RecommendationDataForConsigner recommendationDataForConsigner);

    List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(Long caretakerKey);


}
