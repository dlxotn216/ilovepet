/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.user.caretaker.service;

import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.model.Consigner;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
public interface CaretakerService {
    Integer addCaretaker(Caretaker caretaker);

    Integer updateCaretaker(Caretaker caretaker);

    Caretaker getCaretakerByUserKey(Long userKey);

    Caretaker getCaretakerFromCurrentSession();

    List<Consigner> getUsersForCaretaker(UserCriteria userCriteria);

    Integer getUsersForCaretakerTotalCount(UserCriteria userCriteria);
}
