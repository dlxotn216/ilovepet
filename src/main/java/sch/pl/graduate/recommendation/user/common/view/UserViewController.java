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
import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.code.service.CodeService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.CityType;
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
    private CodeService codeService;

    @Autowired
    private UserService userService;

    @GetMapping("/myprofile")
    public String getMyProfileDetailView(Model model){
        User user = userService.getUserFromCurrentSession();
        List<CityType> cityTypes = codeService.getCityTypes(new CodeCriteria());
        model.addAttribute("profile", user);
        model.addAttribute("cityTypes", cityTypes);
        return "user/myprofileDetail";
    }

    @GetMapping("/myprofile/update")
    public String getMyProfileUpdateView(Model model){
        User user = userService.getUserFromCurrentSession();
        List<CityType> cityTypes = codeService.getCityTypes(new CodeCriteria());
        model.addAttribute("profile", user);
        model.addAttribute("cityTypes", cityTypes);
        return "user/myprofileUpdate";
    }

}
