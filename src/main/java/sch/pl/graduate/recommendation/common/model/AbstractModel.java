/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.common.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import sch.pl.graduate.recommendation.common.util.SqlTimestampSerializer;

import java.sql.Timestamp;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class AbstractModel {
    private String description;
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp createdAt;
}
