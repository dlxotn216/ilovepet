/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.pet.model;

import lombok.Data;
import sch.pl.graduate.recommendation.Epidemic.model.Epidemic;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.file.model.File;
import sch.pl.graduate.recommendation.user.model.GenderType;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class Pet extends AbstractModel {
    private Long petKey;
    private String petName;
    private PetType petType;
    private List<Epidemic> epidemic;        //전염병
    private GenderType gender;
    private Boolean neutralizing;
    private Double barking;         //짖음
    private Double marking;         //마킹
    private Double mounting;        //마운팅
    private Double aggression;      //공격성
    private Double size;
    private List<File> profileFile;
}
