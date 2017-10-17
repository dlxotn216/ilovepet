package sch.pl.graduate.recommendation.file.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.file.model.AppFile;

import java.util.List;

/**
 * Created by taesu on 2017-10-15.
 */
@Repository
@Mapper
public interface FileMapper {
    Long addFile(AppFile appFile);

    Long addFiles(List<AppFile> appFiles);

    AppFile getFileByFileKey(Long fileKey);

    List<AppFile> getFilesWhereFileKeyIsBiggerThan(Long fileKey);

    List<AppFile> getFileByFileKeys(List<? extends AppFile> files);

    Integer deleteFiles(List<? extends AppFile> files);
}
