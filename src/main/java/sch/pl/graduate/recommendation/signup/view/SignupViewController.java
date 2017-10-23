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
import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.code.service.CodeService;
import sch.pl.graduate.recommendation.signup.model.SignupValue;
import sch.pl.graduate.recommendation.signup.service.SignupService;
import sch.pl.graduate.recommendation.user.common.model.CityType;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
public class SignupViewController {

    @Autowired
    private CodeService codeService;

    @Autowired
    private SignupService signupService;

    @GetMapping({"/signup"})
    public String getDefaultSignupView(Model model, @RequestParam(required = false) String target) {
        SignupValue signupValue = signupService.getSignupValue(target);
        List<CityType> cityTypes = codeService.getCityTypes(new CodeCriteria());
        model.addAttribute("signupValue", signupValue);
        model.addAttribute("cityTypes", cityTypes);

        return "signup/signup";
    }

}
