/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.pet.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.pet.model.PetCriteria;
import sch.pl.graduate.recommendation.pet.model.PetType;
import sch.pl.graduate.recommendation.pet.service.PetService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Controller
@RequestMapping("/pet")
public class PetViewController extends AbstractController {

    @Autowired
    private PetService petService;

    @GetMapping({"", "/"})
    public String getPetsView(Model model, PetCriteria petCriteria) {
        List<Pet> pets = petService.getPets(petCriteria);
        model.addAttribute("pets", pets);

        return "pet/pet";
    }

    @GetMapping({"/add"})
    public String getPetAddView(Model model, PetCriteria petCriteria) {
        List<PetType> petTypes = petService.getPetTypes(petCriteria);
        model.addAttribute("petTypes", petTypes);

        return "pet/petAdd";
    }

    @GetMapping({"/{petKey}/detail"})
    public String getPetDetailView(Model model, @PathVariable("petKey") Long petKey) {
        Pet pet = petService.getPetByPetKey(petKey);
        model.addAttribute("pet", pet);

        Boolean isOwner = petService.currentUserIsOwner(pet);
        model.addAttribute("isOwner", isOwner);

        return "pet/petDetail";
    }

    @GetMapping({"/{petKey}/update"})
    public String getPetUpdateView(Model model, @PathVariable("petKey") Long petKey) {
        List<PetType> petTypes = petService.getPetTypes(new PetCriteria());
        model.addAttribute("petTypes", petTypes);

        Pet pet = petService.getPetByPetKey(petKey);
        model.addAttribute("pet", pet);

        Boolean isOwner = petService.currentUserIsOwner(pet);

        if(!isOwner){
            return "error/403";
        } else{
            return "pet/petUpdate";
        }

    }
}
