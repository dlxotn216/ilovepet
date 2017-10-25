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
import sch.pl.graduate.recommendation.dashboard.service.DashboardForCaretakerService;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@RestController
public class DashboardForCaretakerController extends AbstractController {

    @Autowired
    private DashboardForCaretakerService dashboardForCaretakerService;

    @GetMapping("/caretakers/dashboard/cares")
    public ResponseEntity monthlyCareLogAsAllUser() {
        return getSuccessResponse(dashboardForCaretakerService.monthlyCareLogAsAllUser(), "성공");
    }

    @GetMapping("/caretakers/dashboard/my-cares")
    public ResponseEntity monthlyCareLogAsCurrentUser() {
        return getSuccessResponse(dashboardForCaretakerService.monthlyCareLogAsCurrentUser(), "성공");
    }

    @GetMapping("/caretakers/dashboard/added-pets")
    public ResponseEntity monthlyAddedPetLog() {
        return getSuccessResponse(dashboardForCaretakerService.monthlyAddedPetLog(), "성공");
    }

    @GetMapping("/caretakers/dashboard/added-consigners")
    public ResponseEntity monthlyAddedConsignerLog() {
        return getSuccessResponse(dashboardForCaretakerService.monthlyAddedConsignerLog(), "성공");
    }
}
