/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-26
 */
package sch.pl.graduate.recommendation.user.admin.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-26.
 */
@Data
public class DashboardForLoginHistoryInner extends AbstractModel{
    private Boolean isSuccess;
    private Long count;
}
