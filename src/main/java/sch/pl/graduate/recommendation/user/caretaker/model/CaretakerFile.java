/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.user.caretaker.model;

import lombok.Data;
import sch.pl.graduate.recommendation.file.model.AppFile;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
@Data
public class CaretakerFile extends AppFile {
    private Long userKey;
    private Long fileKey;
}
