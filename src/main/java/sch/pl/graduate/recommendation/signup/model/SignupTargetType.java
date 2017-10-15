/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.signup.model;

import sch.pl.graduate.recommendation.common.util.HashMapUtil;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
public enum SignupTargetType {
    Consigner(0, "ROLE_CONSIGNER", "맡기미 회원가입"),
    Caretaker(1, "ROLE_CARETAKER", "돌보미 회원가입");

    private static final Map<Integer, SignupTargetType> lookup = new HashMap<>(HashMapUtil.getCapacity(4));
    private static final Map<String, SignupTargetType> lookupValue = new HashMap<>(HashMapUtil.getCapacity(4));
    private static final Map<String, SignupTargetType> nameValue = new HashMap<>(HashMapUtil.getCapacity(4));

    static {
        for (SignupTargetType type : EnumSet.allOf(SignupTargetType.class)){
            lookup.put(type.getCode(), type);
            lookupValue.put(type.getValue(), type);
            nameValue.put(type.getName(), type);
        }
    }

    public static SignupTargetType get(int code) {
        return lookup.get(code);
    }

    public static SignupTargetType getValue(int code) {
        return lookupValue.get(code);
    }

    public static SignupTargetType getName(int code) {
        return nameValue.get(code);
    }


    private Integer code;
    private String value;
    private String name;

    SignupTargetType(Integer code, String value, String name) {
        this.code = code;
        this.value = value;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
