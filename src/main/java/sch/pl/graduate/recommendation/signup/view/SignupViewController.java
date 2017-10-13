/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.signup.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sch.pl.graduate.recommendation.signup.model.SignupValue;
import sch.pl.graduate.recommendation.signup.service.SignupService;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
public class SignupViewController {

    @Autowired
    private SignupService signupService;

    @GetMapping({"/signup"})
    public String getDefaultSignupView(Model model, @RequestParam(required = false) String target) {
        SignupValue signupValue = signupService.getSignupValue(target);
        model.addAttribute("signupValue", signupValue);
        model.addAttribute("isSignupView", true);

        return "signup/signup";
    }

}
