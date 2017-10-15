package sch.pl.graduate.recommendation.file.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.file.model.File;

/**
 * Created by taesu on 2017-10-15.
 */
@Repository
@Mapper
public interface FileMapper {
    Integer addFile(File file);
}
