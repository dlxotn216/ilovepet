/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
 */
package sch.pl.graduate.recommendation.pet.service;

import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.pet.model.PetCare;
import sch.pl.graduate.recommendation.pet.model.PetCriteria;
import sch.pl.graduate.recommendation.pet.model.PetType;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
public interface PetService {
    Integer addPet(Pet pet);

    Pet getPetByPetKey(Long petKey);

    List<Pet> getPets(PetCriteria petCriteria);

    Integer getPetsTotalCount(PetCriteria petCriteria);

    Integer updatePet(Pet pet);

    Integer deletePet(Pet pet);

    Boolean currentUserIsOwner(Pet pet);

    List<PetCare> getPetCareLog(Long petKey);
}
