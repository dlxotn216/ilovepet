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
import sch.pl.graduate.recommendation.user.common.service.UserService;

/**
 * Created by Lee Tae Su on 2017-10-18.
 */
@Controller
public class UserViewController {

    @Autowired
    private UserService userService;

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
