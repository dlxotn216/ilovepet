/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-24
 */
package sch.pl.graduate.recommendation.care.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.common.util.SqlTimestampDeserializer;
import sch.pl.graduate.recommendation.common.util.SqlTimestampSerializer;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-24.
 */
@Data
public class Care extends AbstractModel {
    private Long careKey;
    private Long caretakerKey;
    private Long consignerKey;
    private Integer day;
    @JsonDeserialize(using = SqlTimestampDeserializer.class)
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp startAt;
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp endAt;
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp finishedAt;
    private Integer price;

    private List<CareDetail> careDetails;
}
