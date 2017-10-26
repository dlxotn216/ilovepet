/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.dashboard.model;

import lombok.Data;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Data
public class Dashboard {
    private String month;
    private String date;
    private Long count;
    private String cityName;
}
