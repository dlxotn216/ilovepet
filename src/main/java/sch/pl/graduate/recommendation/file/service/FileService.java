package sch.pl.graduate.recommendation.file.service;

import org.springframework.web.multipart.MultipartFile;
import sch.pl.graduate.recommendation.file.model.FileType;

/**
 * Created by taesu on 2017-10-15.
 */
public interface FileService {
    Integer addFile(MultipartFile multipartFile, FileType fileType);
}
