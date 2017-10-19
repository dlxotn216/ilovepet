/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.user.caretaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.caretaker.service.CaretakerService;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
@RestController
public class CaretakerController extends AbstractController {

    @Autowired
    private CaretakerService caretakerService;

    @PostMapping("/users/{userKey}/caretakers")
    public ResponseEntity addCaretaker(@PathVariable Long userKey, @RequestBody Caretaker caretaker) {
        caretaker.setUserKey(userKey);
        Integer result = caretakerService.addCaretaker(caretaker);

        return getSuccessResponse(result, "요청 성공하였습니다");
    }

    @PutMapping("/users/{userKey}/caretakers")
    public ResponseEntity updateCaretaker(@PathVariable Long userKey, @RequestBody Caretaker caretaker) {
        caretaker.setUserKey(userKey);
        Integer result = caretakerService.updateCaretaker(caretaker);

        return getSuccessResponse(result, "요청 성공하였습니다");
    }
}
