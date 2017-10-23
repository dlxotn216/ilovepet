/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.user.common.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Data
public class CityType extends AbstractModel{
    private Long cityTypeKey;
    private String cityTypeName;
}
