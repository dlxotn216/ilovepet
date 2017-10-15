package sch.pl.graduate.recommendation.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.file.model.FileType;
import sch.pl.graduate.recommendation.file.service.FileService;

/**
 * Created by taesu on 2017-10-14.
 */
@RestController
public class FileController extends AbstractController {
    private Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/files")
    public ResponseEntity addFile(@RequestPart("file") MultipartFile file,
                                  @RequestParam("fileType") FileType fileType) {
        if (file.isEmpty()) {
            return getFailResponse(false, "업로드 실패");
        }

        fileService.addFile(file, fileType);
        return getSuccessResponse(true, "업로드 성공하였습니다");
    }
}
