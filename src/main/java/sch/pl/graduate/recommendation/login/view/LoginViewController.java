/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.login.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
@RequestMapping("/login")
public class LoginViewController {
    @GetMapping({"", "/"})
    public String getLoginView() {
        return "login/login";
    }

}
