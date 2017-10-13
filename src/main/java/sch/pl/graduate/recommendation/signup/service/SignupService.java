/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.signup.service;

import sch.pl.graduate.recommendation.signup.model.SignupValue;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
public interface SignupService {

    void signup();

    SignupValue getSignupValue(String param);
}
