/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.user.admin.service;

import sch.pl.graduate.recommendation.user.admin.model.DashboardForLoginHistory;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
public interface AdminService {
    List<DashboardForLoginHistory> getSystemLoginHistoriesByMonth();
    List<DashboardForLoginHistory> getSystemLoginHistoriesByDaily();

    void generateDefaultData();
}
