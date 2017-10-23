/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.code.service;

import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.pet.model.PetType;
import sch.pl.graduate.recommendation.user.common.model.CityType;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
public interface CodeService {

    List<PetType> getPetTypes(CodeCriteria codeCriteria);

    List<CityType> getCityTypes(CodeCriteria codeCriteria);

}
