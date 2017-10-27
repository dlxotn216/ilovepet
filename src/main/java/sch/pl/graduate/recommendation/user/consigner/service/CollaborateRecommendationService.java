/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.service;

import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.consigner.model.ConsignerWithCaretakerMatrix;
import sch.pl.graduate.recommendation.user.consigner.model.ExpectedScore;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
public interface CollaborateRecommendationService {
    Double getSimilarity(ConsignerWithCaretakerMatrix currentUserRow, ConsignerWithCaretakerMatrix otherUserRow);

    //계산
    List<Caretaker> recommendByPreviousLog(List<Caretaker> previousLog);

    @Deprecated
    List<ConsignerWithCaretakerMatrix> getConsignerAndCaretakerMatrix();

    List<ExpectedScore> getExpectedScore(ConsignerWithCaretakerMatrix currentUserRow, ConsignerWithCaretakerMatrix otherUserRow);
}
