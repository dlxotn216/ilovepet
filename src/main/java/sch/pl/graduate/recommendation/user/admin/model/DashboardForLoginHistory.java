/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.user.admin.model;

import lombok.Data;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Data
public class DashboardForLoginHistory {
    private String month;
    private Integer isSuccess;
    private Integer count;
}
