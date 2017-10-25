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
    List<Dashboard> monthlyCareLogAsAllUser();

    List<Dashboard> monthlyCareLogAsCurrentUser();

    List<Dashboard> monthlyAddedPetLog();

    List<Dashboard> monthlyAddedConsignerLog();
}
