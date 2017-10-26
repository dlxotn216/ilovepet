/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.dashboard.service;

import sch.pl.graduate.recommendation.dashboard.model.Dashboard;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
public interface DashboardForCaretakerService {
    List<Dashboard> getMonthlyCareLogAsAllUser();
    List<Dashboard> getDailyCareLogAsAllUser();

    List<Dashboard> getMonthlyCareLogAsCurrentUser();
    List<Dashboard> getDailyCareLogAsCurrentUser();

    List<Dashboard> getMonthlyAddedPetLog();
    List<Dashboard> getDailyAddedPetLog();

    List<Dashboard> getMonthlyAddedConsignerLog();
    List<Dashboard> getDailyAddedConsignerLog();
}
