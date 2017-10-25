/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.user.admin.model.DashboardForLoginHistory;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Repository
@Mapper
public interface AdminMapper {
    List<DashboardForLoginHistory> getSystemLoginHistoriesByMonth();
}
