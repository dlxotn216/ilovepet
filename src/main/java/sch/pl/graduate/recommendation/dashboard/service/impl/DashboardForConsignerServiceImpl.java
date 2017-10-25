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
import sch.pl.graduate.recommendation.dashboard.mapper.DashboardForConsignerMapper;
import sch.pl.graduate.recommendation.dashboard.model.Dashboard;
import sch.pl.graduate.recommendation.dashboard.service.DashboardForConsignerService;

import java.util.List;
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Service
public class DashboardForConsignerServiceImpl extends AbstractService implements DashboardForConsignerService {
    @Autowired
    private DashboardForConsignerMapper dashboardForConsignerMapper;

    @Override
    public List<Dashboard> getMonthlyAddedPetLog() {
        List<Dashboard> result = dashboardForConsignerMapper.getMonthlyAddedPetLog();
        return result;
    }

    @Override
    public List<Dashboard> getMonthlyCareServiceUsageLog() {
        List<Dashboard> result =  dashboardForConsignerMapper.getMonthlyCareServiceUsageLog();
        return result;
    }

    @Override
    public List<Dashboard> getMonthlyAddedCaretakerLog() {
        List<Dashboard> result =  dashboardForConsignerMapper.getMonthlyAddedCaretakerLog();
        return result;
    }

    @Override
    public List<Dashboard> getNumOfCaretakerAsCity() {
        List<Dashboard> result =  dashboardForConsignerMapper.getNumOfCaretakerAsCity();
        return result;
    }
}
