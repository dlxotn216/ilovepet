/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-24
 */
package sch.pl.graduate.recommendation.pet.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.common.util.SqlTimestampSerializer;

import java.sql.Timestamp;

/**
 * Created by Lee Tae Su on 2017-10-24.
 */
@Data
public class PetCare extends AbstractModel {
    private Long consignerKey;
    private String consignerId;
    private String consignerName;
    private Long caretakerKey;
    private String caretakerId;
    private String caretakerName;
    private Long petKey;
    private Long careKey;
    private Double score;
    private String comment;

    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp startAt;
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp endAt;
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp finishedAt;
}
