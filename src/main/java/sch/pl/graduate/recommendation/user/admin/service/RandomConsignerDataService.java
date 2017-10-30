/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-30
 */
package sch.pl.graduate.recommendation.user.admin.service;

import sch.pl.graduate.recommendation.user.common.model.GenderType;

/**
 * Created by Lee Tae Su on 2017-10-30.
 */
public interface RandomConsignerDataService {
    String getRandomUserId();

    String getPrefixedPassword();

    String getRandomUserName();

    String getRandomPhone();

    String getRandomBirth();

    GenderType getRandomGender();

    String getRandomEmail(String userId);

    Long getRandomCity();
}
