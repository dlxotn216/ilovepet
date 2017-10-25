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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.model.CareReview;
import sch.pl.graduate.recommendation.care.service.CareService;
import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.code.service.CodeService;
import sch.pl.graduate.recommendation.common.controller.AbstractViewController;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.pet.model.PetCriteria;
import sch.pl.graduate.recommendation.pet.service.PetService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.CityType;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.consigner.service.ConsignerService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
public class ConsignerViewController extends AbstractViewController {

    @Autowired
    private ConsignerService consignerService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private PetService petService;

    @Autowired
    private CareService careService;

    @GetMapping({"/consigner", "/consigner/"})
    public String getConsignerView() {
        return "consigner/dashboard";
    }

    @GetMapping("/consigner/user")
    public String getUsersForConsignerView(Model model, UserCriteria userCriteria) {
        List<Caretaker> users = consignerService.getUsersForConsigner(userCriteria);
        final Integer totalCount = consignerService.getUsersForConsignerTotalCount(userCriteria);
        final Integer totalPage = totalCount / userCriteria.getLimit();
        final Integer currentPage = userCriteria.getPage();

        model.addAttribute("users", users);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage == 0 ? 1 : totalPage);
        model.addAttribute("currentPage", currentPage);

        return getListView(model, "consigner/caretakerList");
    }

    @GetMapping("/consigner/user/{userKey}/detail")
    public String getUserDetailForConsignerView(Model model, @PathVariable Long userKey) {
        Caretaker user = consignerService.getUserForConsigner(userKey);
        model.addAttribute("user", user);

        PetCriteria petCriteria = new PetCriteria();
        petCriteria.setLimit(-1);
        List<Pet> pets = petService.getPets(petCriteria);
        model.addAttribute("pets", pets);

        List<Care> cares = consignerService.getCareLogsByCaretakerKeyAndWithoutAddCareReview(userKey);
        model.addAttribute("cares", cares);

        List<CareReview> careReviews = careService.getCareReviewsByCaretakerKey(userKey);
        model.addAttribute("careReviews", careReviews);

        return "consigner/caretakerDetail";
    }

    @GetMapping("/consigner/recommendation")
    public String getRecommendationForConsignerView(Model model) {
        List<Caretaker> caretakers = consignerService.getRecommendedCaretakers();
        Boolean dataNotEnough = caretakers == null;

        model.addAttribute("caretakers", caretakers);
        model.addAttribute("dataNotEnough", dataNotEnough);

        if(dataNotEnough) {
            return getNotEnoughForRecommendationView(model, null);
        } else {
            return getResultRecommendationView(model);
        }
    }

    @GetMapping("/consigner/recommendation/not-enough")
    public String getNotEnoughForRecommendationView(Model model,
                                                    @RequestParam(required = false) Long selectedPetKey) {
        List<CityType> cityTypes = codeService.getCityTypes(new CodeCriteria());
        model.addAttribute("cityTypes", cityTypes);
        if(selectedPetKey != null){
            Pet selectedPet = petService.getPetByPetKey(selectedPetKey);
            model.addAttribute("selectedPet", selectedPet);
        }
        return "consigner/recommendation/notEnough";
    }

    @GetMapping("/consigner/recommendation/result")
    public String getResultRecommendationView(Model model) {
        return "consigner/recommendation/result";
    }

    @GetMapping("/consigner/recommendation/select-pet")
    public String getSelectPetForRecommendationView(Model model, PetCriteria petCriteria) {
        List<Pet> pets = petService.getPets(petCriteria);
        final Integer totalCount = petService.getPetsTotalCount(petCriteria);
        final Integer totalPage = totalCount / petCriteria.getLimit();
        final Integer currentPage = petCriteria.getPage();

        model.addAttribute("pets", pets);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage == 0 ? 1 : totalPage);
        model.addAttribute("currentPage", currentPage);

        final String redirectUrl = petCriteria.getRedirect();
        if(!StringUtils.isEmpty(redirectUrl)) {
            model.addAttribute("redirectUrl", redirectUrl);
        }
        return "consigner/recommendation/selectPet";
    }

}
