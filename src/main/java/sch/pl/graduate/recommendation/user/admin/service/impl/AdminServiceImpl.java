/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.user.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.admin.mapper.AdminMapper;
import sch.pl.graduate.recommendation.user.admin.model.DashboardForLoginHistory;
import sch.pl.graduate.recommendation.user.admin.service.AdminService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Service
public class AdminServiceImpl extends AbstractService implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<DashboardForLoginHistory> getSystemLoginHistoriesByMonth() {
        return adminMapper.getSystemLoginHistoriesByMonth();
    }

    @Override
    public List<DashboardForLoginHistory> getSystemLoginHistoriesByDaily() {
        List<DashboardForLoginHistory> result = adminMapper.getSystemLoginHistoriesByDaily();
        return result;
    }
}
