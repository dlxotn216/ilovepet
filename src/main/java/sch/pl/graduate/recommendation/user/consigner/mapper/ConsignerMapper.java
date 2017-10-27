package sch.pl.graduate.recommendation.user.consigner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;

import java.util.List;

/**
 * Created by taesu on 2017-10-21.
 */
@Repository
@Mapper
public interface ConsignerMapper {

    List<Caretaker> getUsersForConsigner(UserCriteria userCriteria);

    Integer getUsersForConsignerTotalCount(UserCriteria userCriteria);

    Caretaker getUserForConsigner(Long userKey);
}
