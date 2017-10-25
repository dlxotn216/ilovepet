/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.user.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.user.admin.service.AdminService;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@RestController
public class AdminController extends AbstractController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins/login/histories")
    public ResponseEntity getSystemLoginHistoriesByMonth() {
        return getSuccessResponse(adminService.getSystemLoginHistoriesByMonth(), "성공하였습니다");
    }
}
