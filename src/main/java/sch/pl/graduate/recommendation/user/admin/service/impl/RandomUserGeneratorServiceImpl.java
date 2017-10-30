/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-30
 */
package sch.pl.graduate.recommendation.user.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.user.admin.service.RandomCaretakerDataService;
import sch.pl.graduate.recommendation.user.admin.service.RandomConsignerDataService;
import sch.pl.graduate.recommendation.user.admin.service.RandomUserGeneratorService;
import sch.pl.graduate.recommendation.user.caretaker.mapper.CaretakerMapper;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.mapper.UserMapper;
import sch.pl.graduate.recommendation.user.common.model.GenderType;
import sch.pl.graduate.recommendation.user.consigner.model.Consigner;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Lee Tae Su on 2017-10-30.
 */
@Service
public class RandomUserGeneratorServiceImpl extends AbstractService implements RandomUserGeneratorService {

    private static final Logger log = LoggerFactory.getLogger(RandomUserGeneratorServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CaretakerMapper caretakerMapper;

    @Autowired
    @Qualifier("ConsignerRandom")
    private RandomConsignerDataService randomConsignerDataService;

    @Autowired
    @Qualifier("CaretakerRandom")
    private RandomCaretakerDataService randomCaretakerDataService;

    @Override
    public void addRandomConsigner() {
        Consigner consigner = new Consigner();
        String userId = randomConsignerDataService.getRandomUserId();
        String password = randomConsignerDataService.getPrefixedPassword();
        String userName = randomConsignerDataService.getRandomUserName();
        String phone = randomConsignerDataService.getRandomPhone();
        String birth = randomConsignerDataService.getRandomBirth();
        GenderType genderType = randomConsignerDataService.getRandomGender();
        String email = randomConsignerDataService.getRandomEmail(userId);
        Long randomCity = randomConsignerDataService.getRandomCity();

        consigner.setUserId(userId);
        consigner.setPassword(password);
        consigner.setUserName(userName);
        consigner.setPhone(phone);
        consigner.setBirth(birth);
        consigner.setGender(genderType);
        consigner.setEmail(email);
        consigner.setCityTypeKey(randomCity);
        consigner.setRoleKey(2L);        //consigner

        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        Timestamp createdAt = new Timestamp(currentMillis);
        consigner.setCreatedAt(createdAt);

        log.info("user id : " + userId);
        log.info("user password : " + password);
        log.info("user userName : " + userName);
        log.info("user phone : " + phone);
        log.info("user birth : " + birth);
        log.info("user genderType : " + genderType);
        log.info("user email : " + email);
        log.info("user randomCity : " + randomCity);

        userMapper.addUser(consigner);

    }

    @Override
    public void addRandomCaretaker() {
        Caretaker caretaker = new Caretaker();
        String userId = randomCaretakerDataService.getRandomUserId();
        String password = randomCaretakerDataService.getPrefixedPassword();
        String userName = randomCaretakerDataService.getRandomUserName();
        String phone = randomCaretakerDataService.getRandomPhone();
        String birth = randomCaretakerDataService.getRandomBirth();
        GenderType genderType = randomCaretakerDataService.getRandomGender();
        String email = randomCaretakerDataService.getRandomEmail(userId);
        Long randomCity = randomCaretakerDataService.getRandomCity();

        caretaker.setUserId(userId);
        caretaker.setPassword(password);
        caretaker.setUserName(userName);
        caretaker.setPhone(phone);
        caretaker.setBirth(birth);
        caretaker.setGender(genderType);
        caretaker.setEmail(email);
        caretaker.setCityTypeKey(randomCity);
        caretaker.setRoleKey(3L);        //caretaker
        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        Timestamp createdAt = new Timestamp(currentMillis);
        caretaker.setCreatedAt(createdAt);

        log.info("user id : " + userId);
        log.info("user password : " + password);
        log.info("user userName : " + userName);
        log.info("user phone : " + phone);
        log.info("user birth : " + birth);
        log.info("user genderType : " + genderType);
        log.info("user email : " + email);
        log.info("user randomCity : " + randomCity);

        Integer petCount = randomCaretakerDataService.getRandomPetCount();
        String title = randomCaretakerDataService.getRandomTitle();
        Integer peePerNight = randomCaretakerDataService.getRandomPeePerNight();
        Integer additionalFee = randomCaretakerDataService.getRandomAdditionalFee();
        String checkIn = randomCaretakerDataService.getRandomCheckInTime();
        String checkoutTime = randomCaretakerDataService.getRandomCheckoutTime();
        Boolean yard = randomCaretakerDataService.getRandomYard();
        Boolean liveWithFamily = randomCaretakerDataService.getRandomLiveWithFamily();
        Boolean youngChildren = randomCaretakerDataService.getRandomYoungChildren();
        Boolean pickup = randomCaretakerDataService.getRandomPickup();
        String summary = randomCaretakerDataService.getRandomSummary();
        Double barking = randomCaretakerDataService.getRandomBarking();
        Double marking = randomCaretakerDataService.getRandomMarking();
        Double mounting = randomCaretakerDataService.getRandomMounting();
        Double aggression = randomCaretakerDataService.getRandomAggression();
        Double size = randomCaretakerDataService.getRandomSize();

        log.info("petCount : " + petCount);
        log.info("title : " + title);
        log.info("peePerNight : " + peePerNight);
        log.info("additionalFee : " + additionalFee);
        log.info("checkIn : " + checkIn);
        log.info("checkoutTime : " + checkoutTime);
        log.info("yard : " + yard);
        log.info("liveWithFamily : " + liveWithFamily);
        log.info("youngChildren : " + youngChildren);
        log.info("pickup : " + pickup);
        log.info("summary : " + summary);
        log.info("barking : " + barking);
        log.info("marking : " + marking);
        log.info("mounting : " + mounting);
        log.info("aggression : " + aggression);
        log.info("size : " + size);

        caretaker.setPetCount(petCount);
        caretaker.setTitle(title);
        caretaker.setFeePerNight(peePerNight);
        caretaker.setAdditionalFee(additionalFee);
        caretaker.setCheckIn(checkIn);
        caretaker.setCheckOut(checkoutTime);
        caretaker.setYard(yard);
        caretaker.setLiveWithFamily(liveWithFamily);
        caretaker.setHasYoungChildren(youngChildren);
        caretaker.setPickup(pickup);
        caretaker.setSummary(summary);
        caretaker.setBarking(barking);
        caretaker.setMarking(marking);
        caretaker.setMounting(mounting);
        caretaker.setAggression(aggression);
        caretaker.setSize(size);

        userMapper.addUser(caretaker);
        caretakerMapper.addCaretaker(caretaker);
    }
}
