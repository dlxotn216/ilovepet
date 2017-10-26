package sch.pl.graduate.recommendation.notice.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractCriteria;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taesu on 2017-10-25.
 */
@Data
public class NoticeCriteria extends AbstractCriteria{
    private Long noticeKey;

    private static final Map<String, String> MAPPING_FILEDS;
    public static final String userStatusTypePrefix="UserStatusType_";

    static {
        Map<String, String> aMap = new HashMap<>();
        aMap.put("noticeKey", "NOTICE_KEY");
        MAPPING_FILEDS = Collections.unmodifiableMap(aMap);
    }

    @Override
    public String convertFieldToColumn(String field) {
        return MAPPING_FILEDS.get(field);
    }
}
