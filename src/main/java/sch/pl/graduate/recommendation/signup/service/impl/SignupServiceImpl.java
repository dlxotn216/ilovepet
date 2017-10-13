/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.signup.service.impl;

import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.signup.model.SignupTargetType;
import sch.pl.graduate.recommendation.signup.model.SignupValue;
import sch.pl.graduate.recommendation.signup.service.SignupService;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Service
public class SignupServiceImpl implements SignupService {
    @Override
    public void signup() {

    }

    @Override
    public SignupValue getSignupValue(String param) {
        SignupValue signupValue = new SignupValue();

        if(SignupTargetType.Consigner.getValue().equals(param)){
            signupValue.setName(SignupTargetType.Consigner.getName());
            signupValue.setValue(SignupTargetType.Consigner.getValue());
        } else {
            signupValue.setName(SignupTargetType.Caretaker.getName());
            signupValue.setValue(SignupTargetType.Caretaker.getValue());
        }

        return signupValue;
    }
}
