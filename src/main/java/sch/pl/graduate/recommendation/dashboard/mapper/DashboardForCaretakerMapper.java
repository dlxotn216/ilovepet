/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.dashboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.dashboard.model.Dashboard;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Repository
@Mapper
public interface DashboardForCaretakerMapper {
    List<Dashboard> getMonthlyCareLogAsAllUser();
    List<Dashboard> getDailyCareLogAsAllUser();

    List<Dashboard> getMonthlyCareLogAsCurrentUser(Long userKey);
    List<Dashboard> getDailyCareLogAsCurrentUser(Long userKey);

    List<Dashboard> getMonthlyAddedPetLog();
    List<Dashboard> getDailyAddedPetLog();

    List<Dashboard> getMonthlyAddedConsignerLog();
    List<Dashboard> getDailyAddedConsignerLog();
}
