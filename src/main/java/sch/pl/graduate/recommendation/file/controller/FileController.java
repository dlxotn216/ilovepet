package sch.pl.graduate.recommendation.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taesu on 2017-10-14.
 */
@Controller
public class FileController {
    private Logger log = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/files")
    public Map<String, Object> addFile(@RequestPart("file") MultipartFile file) {
        log.info("File uploaed :" + file.getName());
        log.info("File uploaed :" + file.getContentType());

        log.info("File uploaed :" + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        return new HashMap<>();
    }
}
