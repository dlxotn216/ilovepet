/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.home.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sch.pl.graduate.recommendation.home.service.HomeService;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
public class HomeViewController {
    @GetMapping({"/", "/home"})
    public String home() {
        return "home/home";
    }
}
