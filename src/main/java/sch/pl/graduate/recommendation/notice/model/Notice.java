package sch.pl.graduate.recommendation.notice.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

import java.sql.Timestamp;

/**
 * Created by taesu on 2017-10-25.
 */
@Data
public class Notice extends AbstractModel{
    private Long noticeKey;
    private String title;
    private String content;
}
