/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.service;

import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.consigner.model.UserProfileForContentBasedRecommendation;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
public interface ContentBasedRecommendationService {

    List<UserProfileForContentBasedRecommendation> getWeightTable(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation);

    List<? extends Caretaker> getRecommendedCaretakers(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation);
}
