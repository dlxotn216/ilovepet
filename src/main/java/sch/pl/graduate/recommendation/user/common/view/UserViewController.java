/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-18
 */
package sch.pl.graduate.recommendation.user.common.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.common.service.UserService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-18.
 */
@Controller
public class UserViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUsersView(Model model, UserCriteria userCriteria){
        List<User> users = userService.getUsers(userCriteria);
        final Integer totalCount = userService.getUsersTotalCount(userCriteria);
        final Integer totalPage = totalCount / userCriteria.getLimit();
        final Integer currentPage = userCriteria.getPage();

        model.addAttribute("users", users);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", currentPage);

        return "user/user";
    }

    @GetMapping("/myprofile")
    public String getMyProfileView(Model model){
        User user = userService.getUserFromCurrentSession();
        model.addAttribute("profile", user);
        return "user/myprofileDetail";
    }

    @GetMapping("/myprofile/update")
    public String getMyProfileUpdateView(Model model){
        User user = userService.getUserFromCurrentSession();
        model.addAttribute("profile", user);
        return "user/myprofileUpdate";
    }
}
