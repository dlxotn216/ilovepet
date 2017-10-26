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
    public List<Dashboard> getMonthlyCareLogAsAllUser() {
        return dashboardForCaretakerMapper.getMonthlyCareLogAsAllUser();
    }

    @Override
    public List<Dashboard> getDailyCareLogAsAllUser() {
        return dashboardForCaretakerMapper.getDailyCareLogAsAllUser();
    }

    @Override
    public List<Dashboard> getMonthlyCareLogAsCurrentUser() {
        User currentUser = getCurrentUser();
        return dashboardForCaretakerMapper.getMonthlyCareLogAsCurrentUser(currentUser.getUserKey());
    }

    @Override
    public List<Dashboard> getDailyCareLogAsCurrentUser() {
        User currentUser = getCurrentUser();
        return dashboardForCaretakerMapper.getDailyCareLogAsCurrentUser(currentUser.getUserKey());
    }

    @Override
    public List<Dashboard> getMonthlyAddedPetLog() {
        return dashboardForCaretakerMapper.getMonthlyAddedPetLog();
    }

    @Override
    public List<Dashboard> getDailyAddedPetLog() {
        return dashboardForCaretakerMapper.getDailyAddedPetLog();
    }

    @Override
    public List<Dashboard> getMonthlyAddedConsignerLog() {
        return dashboardForCaretakerMapper.getMonthlyAddedConsignerLog();
    }

    @Override
    public List<Dashboard> getDailyAddedConsignerLog() {
        return dashboardForCaretakerMapper.getDailyAddedConsignerLog();
    }
}
