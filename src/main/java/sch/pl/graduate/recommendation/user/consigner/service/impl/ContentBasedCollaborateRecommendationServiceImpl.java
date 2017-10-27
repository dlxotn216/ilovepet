/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-27
 */
package sch.pl.graduate.recommendation.user.consigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.consigner.mapper.RecommendationMapper;
import sch.pl.graduate.recommendation.user.consigner.model.UserProfileForContentBasedRecommendation;
import sch.pl.graduate.recommendation.user.consigner.service.ContentBasedRecommendationService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-27.
 */
@Service
public class ContentBasedCollaborateRecommendationServiceImpl extends AbstractService implements ContentBasedRecommendationService {

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Override
    public List<UserProfileForContentBasedRecommendation> getWeightTable(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation) {
        return recommendationMapper.getWeightTable(userProfileForContentBasedRecommendation);
    }

    @Override
    public List<? extends Caretaker> getRecommendedCaretakers(UserProfileForContentBasedRecommendation userProfileForContentBasedRecommendation) {
        return getWeightTable(userProfileForContentBasedRecommendation);
    }
}
