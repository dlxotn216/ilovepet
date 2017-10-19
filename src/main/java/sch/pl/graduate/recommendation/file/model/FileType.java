/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.file.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.util.HashMapUtil;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */

public enum FileType {
    USER_PROFILE(0),
    PET_PROFILE(1),
    CARETAKER_INTRO(2),
    LOGO(3),
    SYSTEM(4);

    private static final Map<Integer, FileType> lookup = new HashMap<>(HashMapUtil.getCapacity(4));

    static {
        for (FileType type : EnumSet.allOf(FileType.class))
            lookup.put(type.getCode(), type);
    }

    public static FileType get(int code) {
        return lookup.get(code);
    }

    private Integer code;

    FileType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
