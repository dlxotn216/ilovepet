package sch.pl.graduate.recommendation.code.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by taesu on 2017-10-30.
 */
@Data
public class Code extends AbstractModel{
    private Long codeKey;
    private Integer codeSeq;
    private String codeType;
    private String codeName;
}
