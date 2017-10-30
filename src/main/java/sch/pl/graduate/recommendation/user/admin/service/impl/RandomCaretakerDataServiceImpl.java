/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-30
 */
package sch.pl.graduate.recommendation.user.admin.service.impl;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.user.admin.service.RandomCaretakerDataService;

/**
 * Created by Lee Tae Su on 2017-10-30.
 */
@Service
@Qualifier("CaretakerRandom")
public class RandomCaretakerDataServiceImpl extends RandomConsignerDataServiceImpl implements RandomCaretakerDataService {
    @Override
    public Integer getRandomPetCount() {
        return RandomUtils.nextInt(0, 10);
    }


    @Override
    public String getRandomTitle() {
        return summarySources[RandomUtils.nextInt(0, summarySources.length-1)];
    }

    @Override
    public Integer getRandomPeePerNight() {
        return RandomUtils.nextInt(10000, 100000) / 1000 * 1000;
    }

    @Override
    public Integer getRandomAdditionalFee() {
        return RandomUtils.nextInt(10000, 100000) / 1000 * 1000;
    }

    @Override
    public String getRandomCheckInTime() {
        String hour = String.format("%02d", RandomUtils.nextInt(1, 12));
        String min = String.format("%02d", RandomUtils.nextInt(0, 1) * 30);
        return hour + ":" + min;
    }

    @Override
    public String getRandomCheckoutTime() {
        String hour = String.format("%02d", RandomUtils.nextInt(13, 24));
        String min = String.format("%02d", RandomUtils.nextInt(0, 1) * 30);
        return hour + ":" + min;
    }

    @Override
    public Boolean getRandomYard() {
        return RandomUtils.nextInt(0, 10) % 2 == 0;
    }

    @Override
    public Boolean getRandomLiveWithFamily() {
        return RandomUtils.nextInt(0, 10) % 2 == 0;
    }

    @Override
    public Boolean getRandomYoungChildren() {
        return RandomUtils.nextInt(0, 10) % 2 == 0;
    }

    @Override
    public Boolean getRandomPickup() {
        return RandomUtils.nextInt(0, 10) % 2 == 0;
    }

    String[] summarySources = new String[]{
            "친철한 맡기미입니다. 믿고 맡겨주세요~~",
            "잘 돌볼 수 있습니다. 염려 말고 반려 동물을 맡겨 주세요",
            "사랑으로 성심껏 돌봐드릴게요",
            "내집처럼 평안하게 돌봐드려요",
            "내 아이처럼 사랑할게요",
            "언제든지 원하실 때 영상, 사진 보내드릴수 있어요",
            "반려동물이 편한하게~~ 행복하게~~",
            "편히쉬러 오렴~~",
            "자식처럼 돌볼게요",
            "우리 링링이네로 놀러오세요^^~",
            "반려동물은 사랑입니다!!",
            "행복함을 전해주고 싶어요",
            "편하고 아늑한 곳으로 만들어드릴게요",
            "사랑하는 반려 동물을 마음놓고 맡겨 주세요",
            "주인 분 만큼은 아니어도 최선을 다해!!",
            "안심하시고 여행, 출장 다녀오세요~~",
            "애견센터 경력과 반려경험으로 믿고 맡겨 주세요~!",
    };

    @Override
    public String getRandomSummary() {
        return summarySources[RandomUtils.nextInt(0, summarySources.length-1)];
    }

    @Override
    public Double getRandomBarking() {
        return RandomUtils.nextDouble(5, 100);
    }

    @Override
    public Double getRandomMarking() {
        return RandomUtils.nextDouble(5, 100);
    }

    @Override
    public Double getRandomMounting() {
        return RandomUtils.nextDouble(5, 100);
    }

    @Override
    public Double getRandomAggression() {
        return RandomUtils.nextDouble(5, 100);
    }

    @Override
    public Double getRandomSize() {
        return RandomUtils.nextDouble(5, 100);
    }
}
