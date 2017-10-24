/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-24
 */
package sch.pl.graduate.recommendation.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sch.pl.graduate.recommendation.care.model.Care;
import sch.pl.graduate.recommendation.care.model.CareReview;
import sch.pl.graduate.recommendation.care.service.CareService;
import sch.pl.graduate.recommendation.common.controller.AbstractController;

/**
 * Created by Lee Tae Su on 2017-10-24.
 */
@RestController
public class CareController extends AbstractController{

    @Autowired
    private CareService careService;

    @PostMapping("/care")
    public ResponseEntity addCare(@RequestBody Care care){
        Integer result = careService.addCare(care);

        return getSuccessResponse(result, "생성 성공하였습니다");
    }

    @PostMapping("/care/{careKey}/review")
    public ResponseEntity addCareReview(@PathVariable Long careKey,
                                        @RequestBody CareReview careReview){
        careReview.setCareKey(careKey);
        Integer result = careService.addCareReview(careReview);

        return getSuccessResponse(result, "리뷰 성공하였습니다");
    }
}
