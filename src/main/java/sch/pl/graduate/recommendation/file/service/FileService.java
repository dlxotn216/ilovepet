package sch.pl.graduate.recommendation.file.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.model.FileType;

import java.util.List;

/**
 * Created by taesu on 2017-10-15.
 */
public interface FileService {
    AppFile addFile(MultipartFile multipartFile, FileType fileType);

    List<AppFile> addFiles(List<MultipartFile> multipartFiles, FileType fileType);

    AppFile getFileByFileKey(Long fileKey);

    ResponseEntity<byte[]> downloadFile(AppFile appFile);
}
