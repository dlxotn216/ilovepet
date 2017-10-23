/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.care.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.care.mapper.CareMapper;
import sch.pl.graduate.recommendation.care.service.CareService;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Service
public class CareServiceImpl extends AbstractService implements CareService{

    @Autowired
    private CareMapper careMapper;

    @Override
    public List<Caretaker> getCaretakersFromCareLog(){
        User currentUser = getCurrentUser();
        return careMapper.getCaretakersFromCareLog(currentUser);
    }
}
