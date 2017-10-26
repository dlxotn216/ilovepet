/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.dashboard.service.DashboardForConsignerService;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@RestController
public class DashboardForConsignerController extends AbstractController {

    @Autowired
    private DashboardForConsignerService dashboardForConsignerService;

    @GetMapping("/consigners/dashboard/pets")
    public ResponseEntity getDailyAddedPetLog() {
        return getSuccessResponse(dashboardForConsignerService.getDailyAddedPetLog(), "성공");
    }

    @GetMapping("/consigners/dashboard/care/usage")
    public ResponseEntity getDailyCareServiceUsageLog() {
        return getSuccessResponse(dashboardForConsignerService.getDailyCareServiceUsageLog(), "성공");
    }

    @GetMapping("/consigners/dashboard/added-caretakers")
    public ResponseEntity getDailyAddedCaretakerLog() {
        return getSuccessResponse(dashboardForConsignerService.getDailyAddedCaretakerLog(), "성공");
    }

    @GetMapping("/consigners/dashboard/caretakers-by-city")
    public ResponseEntity getNumOfCaretakerAsCity() {
        return getSuccessResponse(dashboardForConsignerService.getNumOfCaretakerAsCity(), "성공");
    }
}
