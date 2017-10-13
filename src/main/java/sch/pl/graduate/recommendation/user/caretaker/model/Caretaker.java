/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.caretaker.model;

import lombok.Data;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.user.model.User;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */

@Data
public class Caretaker extends User {
    private Boolean pickup;
    private List<Pet> caringPets;
    private List<Pet> blacklistPets;
}
