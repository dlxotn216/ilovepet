/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-24
 */
package sch.pl.graduate.recommendation.care.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-24.
 */
@Data
public class CareDetail extends AbstractModel{
    private Long careKey;
    private Long petKey;
}
