/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-25
 */
package sch.pl.graduate.recommendation.user.common.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.common.util.SqlTimestampSerializer;

import java.sql.Timestamp;

/**
 * Created by Lee Tae Su on 2017-10-25.
 */
@Data
@AllArgsConstructor
public class UserLoginHistory extends AbstractModel{
    private Long userKey;
    @JsonSerialize(using = SqlTimestampSerializer.class)
    private Timestamp tryAt;
    private String ip;
    private String userId;
    private Boolean isSuccess;
    private String failReason;
}
