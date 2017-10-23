/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.user.consigner.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.user.common.model.GenderType;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Data
public class RecommendationDataForConsigner extends AbstractModel{
    private Long cityTypeKey;
    private Integer age;
    private GenderType gender;

    private Double barking;         //짖음
    private Double marking;         //마킹
    private Double mounting;        //마운팅
    private Double aggression;      //공격성

    private Boolean yard;
    private Boolean liveWithFamily;
    private Boolean hasYoungChildren;
    private Boolean pickup;
}
