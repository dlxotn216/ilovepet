/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.dashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.dashboard.mapper.DashboardForCaretakerMapper;
import sch.pl.graduate.recommendation.dashboard.model.Dashboard;
import sch.pl.graduate.recommendation.dashboard.service.DashboardForCaretakerService;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Service
public class DashboardForCaretakerServiceImpl extends AbstractService implements DashboardForCaretakerService {
    @Autowired
    private DashboardForCaretakerMapper dashboardForCaretakerMapper;

    @Override
    public List<Dashboard> monthlyCareLogAsAllUser() {
        return dashboardForCaretakerMapper.monthlyCareLogAsAllUser();
    }

    @Override
    public List<Dashboard> monthlyCareLogAsCurrentUser() {
        User currentUser = getCurrentUser();
        return dashboardForCaretakerMapper.monthlyCareLogAsCurrentUser(currentUser.getUserKey());
    }

    @Override
    public List<Dashboard> monthlyAddedPetLog() {
        return dashboardForCaretakerMapper.monthlyAddedPetLog();
    }

    @Override
    public List<Dashboard> monthlyAddedConsignerLog() {
        return dashboardForCaretakerMapper.monthlyAddedConsignerLog();
    }
}
