/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.signup.model;

import lombok.Data;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class SignupValue {
    private String value;
    private String name;
    private SignupTargetType signupTargetType;

}
