/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
 */
package sch.pl.graduate.recommendation.pet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.pet.model.PetCriteria;
import sch.pl.graduate.recommendation.pet.model.PetFile;
import sch.pl.graduate.recommendation.pet.model.PetType;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
@Repository
@Mapper
public interface PetMapper {

    Integer addPet(Pet pet);

    Pet getPet(Pet pet);

    Pet getPetByPetKey(Long petKey);

    Pet getPetByPetName(String petName);

    List<Pet> getPets(PetCriteria petCriteria);

    //위탁받은 반려동물
    List<Pet> getPetsForCaretaker(PetCriteria petCriteria);

    //나의 반려동물
    List<Pet> getPetsForConsigner(PetCriteria petCriteria);

    Integer updatePet(Pet pet);

    Integer deletePet(Pet pet);

    List<PetType> getPetTypes(PetCriteria petTypeCriteria);

    Integer addPetProfileFiles(List<PetFile> files);
}
