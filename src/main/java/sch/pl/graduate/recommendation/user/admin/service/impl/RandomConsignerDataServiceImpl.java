/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-30
 */
package sch.pl.graduate.recommendation.user.admin.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.admin.service.RandomConsignerDataService;
import sch.pl.graduate.recommendation.user.common.model.GenderType;

/**
 * Created by Lee Tae Su on 2017-10-30.
 */
@Service
@Qualifier("ConsignerRandom")
public class RandomConsignerDataServiceImpl extends AbstractService implements RandomConsignerDataService {

    private static final String idSource = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ123456789";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String getRandomUserId() {
        return RandomStringUtils.random(8, idSource);
    }

    @Override
    public String getPrefixedPassword() {
        return passwordEncoder.encode("test");
    }


    private static final String firstNameSource = "김이박최정조배임유심강장";
    private static final String secondNameSource = "대진성태민정희규민병현진예덕";
    private static final String thirdNameSource = "수진민중성민주준만철";

    @Override
    public String getRandomUserName() {
        return RandomStringUtils.random(1, firstNameSource) +
                RandomStringUtils.random(1, secondNameSource) +
                RandomStringUtils.random(1, thirdNameSource);
    }

    private static final String phoneSource = "0123456789";

    @Override
    public String getRandomPhone() {
        return "010" + RandomStringUtils.random(8, phoneSource);
    }

    private static final String birthSource = "";

    @Override
    public String getRandomBirth() {
        String year = String.format("%04d", RandomUtils.nextInt(1970, 2008));
        String month = String.format("%02d", RandomUtils.nextInt(1, 12));
        String day = String.format("%02d", RandomUtils.nextInt(1, 30));
        return year + month + day;
    }

    @Override
    public GenderType getRandomGender() {
        return RandomUtils.nextInt(0, 10) % 2 == 0 ? GenderType.MEN : GenderType.WOMEN;
    }

    private static final String domainSource = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String getRandomEmail(String userId) {
        return userId + "@" + RandomStringUtils.random(5, domainSource) + ".com";
    }


    @Override
    public Long getRandomCity() {
        return RandomUtils.nextLong(1, 15);
    }
}
