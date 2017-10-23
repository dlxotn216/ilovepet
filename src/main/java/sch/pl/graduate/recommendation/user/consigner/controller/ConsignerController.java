/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.user.consigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.consigner.model.RecommendationDataForConsigner;
import sch.pl.graduate.recommendation.user.consigner.service.ConsignerService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Controller
public class ConsignerController extends AbstractController {

    @Autowired
    private ConsignerService consignerService;

    @PostMapping("/consigners/recommendation/process")
    public String calcurateRecommendation(Model model, RecommendationDataForConsigner recommendationDataForConsigner) {
        List<Caretaker> caretakers = consignerService.getRecommendedCaretakersFromRequestData(recommendationDataForConsigner);

        model.addAttribute("caretakers", caretakers);
        return "consigner/recommendation/result";
    }
}
