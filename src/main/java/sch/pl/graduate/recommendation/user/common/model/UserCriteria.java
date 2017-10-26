package sch.pl.graduate.recommendation.user.common.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractCriteria;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taesu on 2017-10-14.
 */
@Data
public class UserCriteria extends AbstractCriteria{
    private Long userKey;
    private String userName;

    private static final Map<String, String> MAPPING_FILEDS;
    public static final String userStatusTypePrefix="UserStatusType_";


    static {
        Map<String, String> aMap = new HashMap<>();
        aMap.put("userKey", "USER_KEY");
        aMap.put("userName", "USER_NAME");
        MAPPING_FILEDS = Collections.unmodifiableMap(aMap);
    }

    @Override
    public String convertFieldToColumn(String field) {
        return MAPPING_FILEDS.get(field);
    }
}
