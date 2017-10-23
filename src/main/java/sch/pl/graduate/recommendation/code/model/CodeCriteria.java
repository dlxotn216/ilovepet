/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.code.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractCriteria;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Data
public class CodeCriteria extends AbstractCriteria{
    private static final Map<String, String> MAPPING_FILEDS;
    public static final String userStatusTypePrefix="UserStatusType_";


    static {
        Map<String, String> aMap = new HashMap<>();

        MAPPING_FILEDS = Collections.unmodifiableMap(aMap);
    }

    @Override
    public String convertFieldToColumn(String field) {
        return MAPPING_FILEDS.get(field);
    }
}
