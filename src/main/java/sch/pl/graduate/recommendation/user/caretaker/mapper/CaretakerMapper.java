/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.user.caretaker.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.caretaker.model.CaretakerFile;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
@Repository
@Mapper
public interface CaretakerMapper {
    Integer addCaretaker(Caretaker caretaker);

    Integer updateCaretaker(Caretaker caretaker);

    Integer addCaretakerIntroFiles(List<CaretakerFile> files);

    Integer deleteCaretakerIntroFilesAsList(List<CaretakerFile> files);

    Caretaker getCaretakerByUserKey(Long userKey);
}
