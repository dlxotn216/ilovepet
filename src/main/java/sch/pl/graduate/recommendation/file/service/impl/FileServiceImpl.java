package sch.pl.graduate.recommendation.file.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.file.mapper.FileMapper;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.model.FileType;
import sch.pl.graduate.recommendation.file.service.FileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taesu on 2017-10-15.
 */
@Service
public class FileServiceImpl extends AbstractService implements FileService {
    private Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private FileMapper fileMapper;

    @Override
    @Transactional
    public AppFile addFile(MultipartFile multipartFile, FileType fileType) {
        final String originalFilename = multipartFile.getOriginalFilename();
        final String uploadFilePath = System.getProperty("catalina.home") + "/" + originalFilename;
        final String format = originalFilename.substring(originalFilename.lastIndexOf("."));
        Integer size = writeFileToUploadFilePath(multipartFile, uploadFilePath);

        AppFile appFile = new AppFile();
        appFile.setFileName(originalFilename);
        appFile.setFilePath(uploadFilePath);
        appFile.setFileType(fileType);
        appFile.setSize(Long.valueOf(size));
        appFile.setFormat(format);

        Long addedFileKey = fileMapper.addFile(appFile);
        return getFileByFileKey(addedFileKey);
    }

    @Override
    @Transactional
    public List<AppFile> addFiles(List<MultipartFile> multipartFiles, FileType fileType) {
        List<AppFile> appFiles = new ArrayList<>();
        for(MultipartFile multipartFile : multipartFiles) {
            final String originalFilename = multipartFile.getOriginalFilename();
            final String uploadFilePath = System.getProperty("catalina.home") + "/" + originalFilename;
            final String format = originalFilename.substring(originalFilename.lastIndexOf("."));
            Integer size = writeFileToUploadFilePath(multipartFile, uploadFilePath);

            AppFile appFile = new AppFile();
            appFile.setFileName(originalFilename);
            appFile.setFilePath(uploadFilePath);
            appFile.setFileType(fileType);
            appFile.setSize(Long.valueOf(size));
            appFile.setFormat(format);
            fileMapper.addFile(appFile);
            appFiles.add(appFile);
        }
        return appFiles;
    }

    private Integer writeFileToUploadFilePath(MultipartFile multipartFile, String uploadFilePath) {
        Integer size;
        try {
            byte[] bytes = multipartFile.getBytes();
            size = bytes.length;
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            log.error("Error occured", e);
            throw new SystemException();
        }
        return size;
    }

    @Override
    public AppFile getFileByFileKey(Long fileKey) {
        return fileMapper.getFileByFileKey(fileKey);
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(AppFile appFile) {
        AppFile appFileFromRepository = getFileByFileKey(appFile.getFileKey());

        final String filePath = appFileFromRepository.getFilePath();
        final String fileName = appFileFromRepository.getFileName();

        File fileForDownload = new File(filePath);

        if (!fileForDownload.exists()){
            throw new SystemException("file with path: " + filePath + " was not found.");
        }
        byte[] bytes;
        try {
            bytes = FileCopyUtils.copyToByteArray(fileForDownload);
        } catch (IOException e) {
            throw new SystemException("file with path: " + filePath + " was not found.");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        httpHeaders.setContentLength(bytes.length);

        httpHeaders.setContentDispositionFormData("attachment", fileName, Charset.forName("UTF-8"));

        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }
}
