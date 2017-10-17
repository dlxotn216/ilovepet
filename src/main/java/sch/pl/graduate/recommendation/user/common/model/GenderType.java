/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.common.model;

import sch.pl.graduate.recommendation.common.util.HashMapUtil;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
public enum GenderType {
    MEN(0, "MEN"),
    WOMEN(1, "WOMEN");

    private static final Map<Integer, GenderType> lookup = new HashMap<>(HashMapUtil.getCapacity(3));
    private static final Map<String, GenderType> lookupValue = new HashMap<>(HashMapUtil.getCapacity(3));

    static {
        for (GenderType type : EnumSet.allOf(GenderType.class))
            lookup.put(type.getCode(), type);
    }

    static {
        for (GenderType type : EnumSet.allOf(GenderType.class))
            lookupValue.put(type.getValue(), type);
    }

    public static GenderType get(int code) {
        return lookup.get(code);
    }

    public static GenderType get(String value) {
        return lookupValue.get(value);
    }

    private Integer code;
    private String value;

    GenderType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
