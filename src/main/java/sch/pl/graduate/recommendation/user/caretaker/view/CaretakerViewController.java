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
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.model.CareReview;
import sch.pl.graduate.recommendation.care.service.CareService;
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

    @Autowired
    private CareService careService;

    @GetMapping({"/caretaker", "/caretaker/"})
    public String getCaretakerView(){
        return "caretaker/dashboard";
    }

    @GetMapping("/caretaker/carelog")
    public String getCareLog(Model model, UserCriteria userCriteria){
        Caretaker user = caretakerService.getCaretakerFromCurrentSession();
        final Long caretakerKey = user.getUserKey();
        model.addAttribute("user", user);

        List<Care> cares = careService.getCaresByCaretakerKey(caretakerKey);
        model.addAttribute("cares", cares);

        List<CareReview> careReviews = careService.getCareReviewsByCaretakerKey(caretakerKey);
        model.addAttribute("careReviews", careReviews);
        return "caretaker/caretakerLog";
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
