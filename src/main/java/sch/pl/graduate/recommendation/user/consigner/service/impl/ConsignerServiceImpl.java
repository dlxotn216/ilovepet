package sch.pl.graduate.recommendation.user.consigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.service.CareService;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.mapper.ConsignerMapper;
import sch.pl.graduate.recommendation.user.consigner.model.RecommendationDataForConsigner;
import sch.pl.graduate.recommendation.user.consigner.service.ConsignerService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by taesu on 2017-10-21.
 */
@Service
public class ConsignerServiceImpl extends AbstractService implements ConsignerService{

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
    public List<Caretaker> getRecommendedCaretakers(){
        List<Caretaker> caretakersFromLog = careService.getCaretakersFromCareLog();

        if(recommendationDataIsEnough(caretakersFromLog)){
            return recommendByPreviousLog(caretakersFromLog);
        } else {
            return null;
        }
    }

    private Boolean recommendationDataIsEnough(List<Caretaker> caretakersFromLog){
        return !CollectionUtils.isEmpty(caretakersFromLog);
    }

    //계산
    private List<Caretaker> recommendByPreviousLog(List<Caretaker> previousLog){
        return consignerMapper.getUsersForConsigner(new UserCriteria());
    }

    @Override
    public List<Caretaker> getRecommendedCaretakersFromRequestData(RecommendationDataForConsigner recommendationDataForConsigner){
        return consignerMapper.getUsersForConsigner(new UserCriteria());
    }

    @Override
    public List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(Long caretakerKey){
        User currentUser = getCurrentUser();
        Long consignerKey = currentUser.getUserKey();
        return careService.getCareLogsByCaretakerKeyAndWithoutAddCareReview(consignerKey, caretakerKey);
    }

}
