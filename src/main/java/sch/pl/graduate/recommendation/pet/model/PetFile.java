/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
 */
package sch.pl.graduate.recommendation.pet.model;

import lombok.Data;
import sch.pl.graduate.recommendation.file.model.AppFile;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
@Data
public class PetFile extends AppFile{
    private Long petKey;
    private Long fileKey;
}
