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
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Repository
@Mapper
public interface DashboardForConsignerMapper {
    List<Dashboard> getMonthlyAddedPetLog();

    List<Dashboard> getMonthlyCareServiceUsageLog();

    List<Dashboard> getMonthlyAddedCaretakerLog();

    List<Dashboard> getNumOfCaretakerAsCity();
}
