/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.caretaker.model;

import lombok.Data;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.pet.model.Pet;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */

@Data
public class Caretaker extends User {
    private Integer petCount;
    private String title;
    private String summary;
    private Integer feePerNight;
    private Integer additionalFee;
    private String checkIn;
    private String checkInHour;
    private String checkInMin;
    private String checkOut;
    private String checkOutHour;
    private String checkOutMin;
    private Boolean yard;
    private Boolean liveWithFamily;
    private Boolean hasYoungChildren;
    private Boolean pickup;
    private Long introductionFileKey;

    //선호 값
    private Double barking;         //짖음
    private Double marking;         //마킹
    private Double mounting;        //마운팅
    private Double aggression;      //공격성
    private Double size;             //크기

    //readonly
    private List<AppFile> introductionFiles;

    private List<CaretakerFile> addedFiles;
    private List<CaretakerFile> deletedFiles;
    private List<Pet> caringPets;
    private List<Pet> blacklistPets;
}
