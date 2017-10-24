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
import sch.pl.graduate.recommendation.pet.model.*;

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
    Integer getPetsTotalCount(PetCriteria petCriteria);

    List<Pet> getPetsForCaretaker(PetCriteria petCriteria);
    Integer getPetsForCaretakerTotalCount(PetCriteria petCriteria);

    List<Pet> getPetsForConsigner(PetCriteria petCriteria);
    Integer getPetsForConsignerTotalCount(PetCriteria petCriteria);

    Integer updatePet(Pet pet);

    Integer deletePet(Pet pet);

    Integer addPetProfileFiles(List<PetFile> files);

    List<AppFile> getPetProfileFiles(Long petKey);

    Integer deletePetProfileFilesAsList(List<PetFile> files);

    Integer deletePetProfileFilesByPetKey(Long petKey);

    List<PetCare> getPetCareLog(Long petKey);
}
