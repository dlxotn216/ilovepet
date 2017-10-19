/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.user.caretaker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.file.service.FileService;
import sch.pl.graduate.recommendation.user.caretaker.mapper.CaretakerMapper;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.caretaker.model.CaretakerFile;
import sch.pl.graduate.recommendation.user.caretaker.service.CaretakerService;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
@Service
public class CaretakerServiceImpl extends AbstractService implements CaretakerService {

    @Autowired
    private CaretakerMapper caretakerMapper;

    @Autowired
    private FileService fileService;

    @Override
    @Transactional
    public Integer addCaretaker(Caretaker caretaker) {
        final Long userKey = caretaker.getUserKey();

        Integer result = caretakerMapper.addCaretaker(caretaker);

        List<CaretakerFile> addedFiles = caretaker.getAddedFiles();
        if(!CollectionUtils.isEmpty(addedFiles)) {
            addedFiles.forEach(item -> item.setUserKey(userKey));
            caretakerMapper.addCaretakerIntroFiles(addedFiles);
        }
        return result;
    }

    @Override
    @Transactional
    public Integer updateCaretaker(Caretaker caretaker) {
        final Long userKey = caretaker.getUserKey();

        List<CaretakerFile> addedFiles = caretaker.getAddedFiles();
        if(!CollectionUtils.isEmpty(addedFiles)) {
            addedFiles.forEach(item -> item.setUserKey(userKey));
            caretakerMapper.addCaretakerIntroFiles(addedFiles);
        }

        List<CaretakerFile> deletedFiles = caretaker.getDeletedFiles();
        if(!CollectionUtils.isEmpty(deletedFiles)) {
            deletedFiles.forEach(item -> item.setUserKey(userKey));
            caretakerMapper.deleteCaretakerIntroFilesAsList(deletedFiles);
            fileService.deleteFiles(deletedFiles);
        }
        return caretakerMapper.updateCaretaker(caretaker);
    }

    @Override
    public Caretaker getCaretakerByUserKey(Long userKey) {
        return caretakerMapper.getCaretakerByUserKey(userKey);
    }
}
