/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-26
 */
package sch.pl.graduate.recommendation.user.consigner.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-26.
 */
@Data
public class ConsignerWithCaretakerMatrix extends AbstractModel {
    private Long consignerKey;
    private Double avg;             //사용가능한 점수 평균
    private Boolean isCurrentUser;  //사용가능한 점수 평균
    private Double similarity;      //현재 세션의 사용자와의 유사도

    private List<CaretakerColumn> caretakerColumns;    //Consigner에 대한 Caretaker 스코어 및 key column
    private List<Double> expectedScores;
}
