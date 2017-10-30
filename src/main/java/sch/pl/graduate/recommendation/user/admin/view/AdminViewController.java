/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.admin.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.common.service.UserService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
public class AdminViewController {
    @Autowired
    private UserService userService;

    @GetMapping({"/admin"})
    public String getAdminView() {
        return "admin/dashboard";
    }

    @GetMapping({"/admin/user"})
    public String getUserForAdminView(Model model, UserCriteria userCriteria) {
        List<? extends User> users = userService.getUsers(userCriteria);
        final Integer totalCount = userService.getUsersTotalCount(userCriteria);
        Integer totalPage = totalCount / userCriteria.getLimit();
        totalPage += (totalCount % userCriteria.getLimit()) == 0 ? 0 : 1;
        final Integer currentPage = userCriteria.getPage();

        model.addAttribute("users", users);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", currentPage);
        return "admin/user";
    }
}
