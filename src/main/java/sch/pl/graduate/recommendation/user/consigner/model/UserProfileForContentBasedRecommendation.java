/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.model;

import lombok.Data;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.GenderType;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
@Data
public class UserProfileForContentBasedRecommendation extends Caretaker {
    private Long caretakerKey;

    private GenderType gender;
    private Double genderWeight;
    private Double genderWeightPercentage;

    private String city;
    private Long cityKey;
    private Double cityWeight;
    private Double cityWeightPercentage;

    private Integer age;
    private Double ageWeight;
    private Double ageWeightPercentage;

    private Boolean yard;
    private Double yardWeight;
    private Double yardWeightPercentage;

    private Boolean liveWithFamily;
    private Double liveWithFamilyWeight;
    private Double liveWithFamilyWeightPercentage;

    private Boolean hasYoungChildren;
    private Double hasYoungChildrenWeight;
    private Double hasYoungChildrenWeightPercentage;

    private Boolean pickup;
    private Double pickupWeight;
    private Double pickupWeightPercentage;

    private Double barking;
    private Double barkingWeight;
    private Double barkingWeightPercentage;

    private Double marking;
    private Double markingWeight;
    private Double markingWeightPercentage;

    private Double mounting;
    private Double mountingWeight;
    private Double mountingWeightPercentage;

    private Double aggression;
    private Double aggressionWeight;
    private Double aggressionWeightPercentage;

    private Double size;
    private Double sizeWeight;
    private Double sizeWeightPercentage;

    private Double weightTotal;
}
