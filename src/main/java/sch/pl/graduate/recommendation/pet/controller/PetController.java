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
import sch.pl.graduate.recommendation.pet.model.PetCriteria;
import sch.pl.graduate.recommendation.pet.service.PetService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
@RestController
public class PetController extends AbstractController {

    @Autowired
    private PetService petService;

    @PostMapping("/pets")
    public ResponseEntity addPet(@RequestBody Pet pet) {
        Integer result = petService.addPet(pet);

        return getSuccessResponse(result, "생성 완료하였습니다");
    }

    @GetMapping("/pets")
    public ResponseEntity getPets(PetCriteria petCriteria) {
        List<Pet> pets = petService.getPets(petCriteria);
        final Integer totalCount = petService.getPetsTotalCount(petCriteria);
        Integer totalPage = totalCount / petCriteria.getLimit();
        totalPage += (totalCount%petCriteria.getLimit()) == 0 ? 0 : 1;
        final Integer currentPage = petCriteria.getPage();

        return getSuccessResponse(pets, totalCount, totalPage, currentPage, "조회 완료하였습니다");
    }

    @PutMapping("/pets/{petKey}")
    public ResponseEntity updatePet(@PathVariable Long petKey, @RequestBody Pet pet) {
        pet.setPetKey(petKey);
        Integer result = petService.updatePet(pet);

        return getSuccessResponse(result, "수정 완료하였습니다");
    }

    @DeleteMapping("/pets/{petKey}")
    public ResponseEntity deletePet(@PathVariable Long petKey) {
        Pet pet = new Pet();
        pet.setPetKey(petKey);
        Integer result = petService.deletePet(pet);

        return getSuccessResponse(result, "삭제 완료하였습니다");
    }
}
