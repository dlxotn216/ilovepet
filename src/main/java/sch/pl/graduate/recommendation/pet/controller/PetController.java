/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
 */
package sch.pl.graduate.recommendation.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.pet.service.PetService;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
@RestController
public class PetController extends AbstractController {

    @Autowired
    private PetService petService;

    @PostMapping("/pets")
    public ResponseEntity addPet(@RequestBody Pet pet){
        Integer result = petService.addPet(pet);

        return getSuccessResponse(result, "생성 완료하였습니다");
    }

    @PutMapping("/pets/{petKey}")
    public ResponseEntity updatePet(@PathVariable Long petKey, @RequestBody Pet pet){
        pet.setPetKey(petKey);
        Integer result = petService.updatePet(pet);

        return getSuccessResponse(result, "수정 완료하였습니다");
    }
}
