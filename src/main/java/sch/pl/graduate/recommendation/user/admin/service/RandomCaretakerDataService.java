/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-30
 */
package sch.pl.graduate.recommendation.user.admin.service;

import sch.pl.graduate.recommendation.user.common.model.GenderType;

import java.sql.Time;

/**
 * Created by Lee Tae Su on 2017-10-30.
 */
public interface RandomCaretakerDataService extends RandomConsignerDataService{

    Integer getRandomPetCount();

    String getRandomTitle();

    Integer getRandomPeePerNight();

    Integer getRandomAdditionalFee();

    String getRandomCheckInTime();

    String getRandomCheckoutTime();

    Boolean getRandomYard();

    Boolean getRandomLiveWithFamily();

    Boolean getRandomYoungChildren();

    Boolean getRandomPickup();

    String getRandomSummary();

    Double getRandomBarking();

    Double getRandomMarking();

    Double getRandomMounting();

    Double getRandomAggression();

    Double getRandomSize();
}
