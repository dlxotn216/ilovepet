/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.caretaker.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.caretaker.service.CaretakerService;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.common.service.UserService;
import sch.pl.graduate.recommendation.user.consigner.model.Consigner;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
public class CaretakerViewController {

    @Autowired
    private CaretakerService caretakerService;

    @GetMapping({"/caretaker", "/caretaker/"})
    public String getCaretakerView(){
        return "caretaker/dashboard";
    }

    @GetMapping("/caretaker/user")
    public String getUsersForCaretakerView(Model model, UserCriteria userCriteria){
        List<Consigner> users = caretakerService.getUsersForCaretaker(userCriteria);
        final Integer totalCount = caretakerService.getUsersForCaretakerTotalCount(userCriteria);
        final Integer totalPage = totalCount / userCriteria.getLimit();
        final Integer currentPage = userCriteria.getPage();

        model.addAttribute("users", users);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage == 0 ? 1 : totalPage);
        model.addAttribute("currentPage", currentPage);

        return "caretaker/consignerList";
    }


    @GetMapping("/myprofile/caretaker")
    public String getMyProfileDetailForCaretakerView(Model model){
        Caretaker user = caretakerService.getCaretakerFromCurrentSession();
        model.addAttribute("profile", user);
        return "user/myprofileDetailForCaretaker";
    }

    @GetMapping("/myprofile/caretaker/add")
    public String getMyProfileAddForCaretakerView(Model model){
        Caretaker user = caretakerService.getCaretakerFromCurrentSession();
        model.addAttribute("profile", user);
        return "user/myprofileAddForCaretaker";
    }

    @GetMapping("/myprofile/caretaker/update")
    public String getMyProfileUpdateForCaretakerView(Model model){
        Caretaker user = caretakerService.getCaretakerFromCurrentSession();
        model.addAttribute("profile", user);
        return "user/myprofileUpdateForCaretaker";
    }
}
