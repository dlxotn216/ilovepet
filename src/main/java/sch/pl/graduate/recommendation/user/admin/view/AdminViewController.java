/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
@RequestMapping("/admin")
public class AdminViewController {
    @GetMapping({"", "/"})
    public String getAdminView(){
        return "admin/admin";
    }
}
