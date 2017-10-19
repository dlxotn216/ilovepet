/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.user.caretaker.service;

import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
public interface CaretakerService {
    Integer addCaretaker(Caretaker caretaker);

    Integer updateCaretaker(Caretaker caretaker);

    Caretaker getCaretakerByUserKey(Long userKey);
}
