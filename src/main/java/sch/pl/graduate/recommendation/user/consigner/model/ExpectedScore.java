/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
@Data
@AllArgsConstructor
public class ExpectedScore extends AbstractModel{
    private Long caretakerKey;
    private Double score;
}
