/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.Epidemic.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class Epidemic extends AbstractModel{
    private long epidemicKey;
    private String epidemicName;
}
