package sch.pl.graduate.recommendation.file.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.file.mapper.FileMapper;
import sch.pl.graduate.recommendation.file.model.File;
import sch.pl.graduate.recommendation.file.model.FileType;
import sch.pl.graduate.recommendation.file.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by taesu on 2017-10-15.
 */
@Service
public class FileServiceImpl implements FileService {
    private Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private FileMapper fileMapper;

    @Override
    public Integer addFile(MultipartFile multipartFile, FileType fileType) {
        final String originalFilename = multipartFile.getOriginalFilename();
        final String uploadFilePath = System.getProperty("catalina.home") + "/" + originalFilename;
        final String format = originalFilename.substring(originalFilename.lastIndexOf("."));
        Integer size = 0;
        try {
            byte[] bytes = multipartFile.getBytes();
            size = bytes.length;
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            log.error("Error occured", e);
            throw new SystemException();
        }

        File file = new File();
        file.setFileName(originalFilename);
        file.setFilePath(uploadFilePath);
        file.setFileType(fileType);
        file.setSize(Long.valueOf(size));
        file.setFormat(format);

        return fileMapper.addFile(file);
    }
}
