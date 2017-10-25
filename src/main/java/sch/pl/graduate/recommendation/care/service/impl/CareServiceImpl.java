/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.care.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sch.pl.graduate.recommendation.care.mapper.CareMapper;
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.model.CareDetail;
import sch.pl.graduate.recommendation.care.model.CareReview;
import sch.pl.graduate.recommendation.care.service.CareService;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Service
public class CareServiceImpl extends AbstractService implements CareService {

    private static final Long DayOfMillis = 1000L * 24 * 60 * 60;

    @Autowired
    private CareMapper careMapper;

    @Override
    @Transactional
    public Integer addCare(Care care) {
        User currentUser = getCurrentUser();

        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        Timestamp startAt = new Timestamp(currentMillis);
        Timestamp endAt = new Timestamp(currentMillis + (DayOfMillis* care.getDay()));

        care.setStartAt(startAt);
        care.setEndAt(endAt);
        care.setFinishedAt(null);
        care.setConsignerKey(currentUser.getUserKey());

        Integer result = careMapper.addCare(care);

        final Long careKey = care.getCareKey();
        if(careKey == null){
            throw new SystemException("CareKey is null");
        }
        List<CareDetail> careDetails = care.getCareDetails();
        if(!CollectionUtils.isEmpty(careDetails)) {
            careDetails.forEach(item -> item.setCareKey(careKey));
            careMapper.addCareDetails(careDetails);
        } else {
            throw new SystemException("맡김 상세정보 누락");
        }

        return result;
    }


    @Override
    public List<Caretaker> getCaretakersFromCareLog() {
        User currentUser = getCurrentUser();
        return careMapper.getCaretakersFromCareLog(currentUser);
    }

    @Override
    public List<Care> getCareLogsByCaretakerKeyAndWithoutAddCareReview(Long consignerKey, Long caretakerKey) {
        return careMapper.getCareLogsByCaretakerKeyAndWithoutAddCareReview(consignerKey, caretakerKey);
    }

    @Override
    public Integer addCareReview(CareReview careReview) {
        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        Timestamp createdAt = new Timestamp(currentMillis);
        careReview.setCreatedAt(createdAt);

        return careMapper.addCareReview(careReview);
    }

    @Override
    public List<CareReview> getCareReviewsByCaretakerKey(Long caretakerKey){
        return careMapper.getCareReviewsByCaretakerKey(caretakerKey);
    }

    @Override
    public List<Care> getCaresByCaretakerKey(Long caretakerKey){
        return careMapper.getCaresByCaretakerKey(caretakerKey);
    }
}
