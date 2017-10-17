/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
 */
package sch.pl.graduate.recommendation.pet.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.pet.mapper.PetMapper;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.pet.model.PetCriteria;
import sch.pl.graduate.recommendation.pet.model.PetFile;
import sch.pl.graduate.recommendation.pet.model.PetType;
import sch.pl.graduate.recommendation.pet.service.PetService;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
@Service
public class PetServiceImpl extends AbstractService implements PetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    @Transactional
    public Integer addPet(Pet pet) {
        User currentUser = getCurrentUser();
        pet.setCaretakerKey(null);
        pet.setOwnerKey(currentUser.getUserKey());

        Integer result = petMapper.addPet(pet);

        List<PetFile> addedFiles = pet.getAddedFiles();
        if(!CollectionUtils.isEmpty(addedFiles)) {
            addedFiles.stream().forEach(item -> item.setPetKey(pet.getPetKey()));
            petMapper.addPetProfileFiles(addedFiles);
        }

        return result;
    }

    @Override
    public List<Pet> getPets(PetCriteria petCriteria) {
        User currentUser = getCurrentUser();
        petCriteria.setOwnerKey(currentUser.getUserKey());
        if(hasRole("ROLE_CARETAKER")) {
            return petMapper.getPetsForCaretaker(petCriteria);
        } else if(hasRole("ROLE_CONSIGNER")) {
            return petMapper.getPetsForConsigner(petCriteria);
        } else if(hasRole("ROLE_ADMIN")) {
            return petMapper.getPets(petCriteria);
        } else {
            throw new SystemException();
        }
    }

    @Override
    public Pet getPetByPetKey(Long petKey) {
        return petMapper.getPetByPetKey(petKey);
    }

    @Override
    public Boolean currentUserIsOwner(Pet pet){
        User currentUser = getCurrentUser();
        return currentUser.getUserKey().equals(pet.getOwnerKey());
    }

    @Override
    public List<PetType> getPetTypes(PetCriteria petTypeCriteria) {
        return petMapper.getPetTypes(petTypeCriteria);
    }
}
