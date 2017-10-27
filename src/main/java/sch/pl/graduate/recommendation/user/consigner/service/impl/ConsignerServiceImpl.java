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
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;
import sch.pl.graduate.recommendation.user.consigner.model.ExpectedScore;
import sch.pl.graduate.recommendation.user.consigner.model.RecommendationDataForConsigner;
import sch.pl.graduate.recommendation.user.consigner.model.UserProfileForContentBasedRecommendation;
import sch.pl.graduate.recommendation.user.consigner.service.CollaborateRecommendationService;
import sch.pl.graduate.recommendation.user.consigner.service.ConsignerService;
import sch.pl.graduate.recommendation.user.consigner.service.ContentBasedRecommendationService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by taesu on 2017-10-21.
 */
@Service
public class ConsignerServiceImpl extends AbstractService implements ConsignerService {

    private static final Logger log = LoggerFactory.getLogger(ConsignerServiceImpl.class);

    private final CareService careService;

    private final ConsignerMapper consignerMapper;

    private final CollaborateRecommendationService collaborateFilteringCollaborateRecommendationService;

    private final ContentBasedRecommendationService contentBasedRecommendationService;

    @Autowired
    public ConsignerServiceImpl(CareService careService, ConsignerMapper consignerMapper, CollaborateRecommendationService collaborateFilteringCollaborateRecommendationService, ContentBasedRecommendationService contentBasedRecommendationService) {
        this.careService = careService;
        this.consignerMapper = consignerMapper;
        this.collaborateFilteringCollaborateRecommendationService = collaborateFilteringCollaborateRecommendationService;
        this.contentBasedRecommendationService = contentBasedRecommendationService;
    }

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
    public List<Caretaker> getRecommendedCaretakersByCollaborateFiltering() {
        List<Caretaker> caretakersFromLog = careService.getCaretakersFromCareLog();

        if(recommendationDataIsEnough(caretakersFromLog)) {
            return collaborateFilteringCollaborateRecommendationService.recommendByPreviousLog(caretakersFromLog);
        } else {
            return null;
        }
    }

    @Override
    public List<ConsignerWithCaretakerMatrix> getConsignerAndCaretakerMatrix() {
        return collaborateFilteringCollaborateRecommendationService.getConsignerAndCaretakerMatrix();
    }

    private Boolean recommendationDataIsEnough(List<Caretaker> caretakersFromLog) {
        return !CollectionUtils.isEmpty(caretakersFromLog);
    }



    @Override
    public List<? extends Caretaker> getRecommendedCaretakersByContentBasedRecommendation(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation) {
        return contentBasedRecommendationService.getRecommendedCaretakers(userProfileForContentBasedRecommendation);
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
