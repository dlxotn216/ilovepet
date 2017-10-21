package sch.pl.graduate.recommendation.user.consigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.mapper.ConsignerMapper;
import sch.pl.graduate.recommendation.user.consigner.service.ConsignerService;

import java.util.List;

/**
 * Created by taesu on 2017-10-21.
 */
@Service
public class ConsignerServiceImpl extends AbstractService implements ConsignerService{

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
}
