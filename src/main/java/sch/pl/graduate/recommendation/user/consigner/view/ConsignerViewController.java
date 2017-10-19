/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.consigner.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.common.service.UserService;
import sch.pl.graduate.recommendation.user.consigner.model.Consigner;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
@RequestMapping("/consigner")
public class ConsignerViewController {

    @Autowired
    private UserService userService;

    @GetMapping({"", "/"})
    public String getConsignerView(){
        return "consigner/consigner";
    }

    @GetMapping("/user")
    public String getUsersForCaretakerView(Model model, UserCriteria userCriteria){
        List<Caretaker> users = userService.getUsersForConsigner(userCriteria);
        final Integer totalCount = userService.getUsersForConsignerTotalCount(userCriteria);
        final Integer totalPage = totalCount / userCriteria.getLimit();
        final Integer currentPage = userCriteria.getPage();

        model.addAttribute("users", users);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", currentPage);

        return "user/user";
    }
}
