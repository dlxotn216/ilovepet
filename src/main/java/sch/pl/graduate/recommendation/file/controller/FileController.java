package sch.pl.graduate.recommendation.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.model.FileType;
import sch.pl.graduate.recommendation.file.service.FileService;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
@RestController
public class FileController extends AbstractController {
    private Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/files")
    public ResponseEntity addFile(@RequestPart("files") List<MultipartFile> files,
                                  @RequestParam("fileType") FileType fileType) {
        if (CollectionUtils.isEmpty(files)) {
            return getFailResponse(false, "업로드 실패");
        }

        for(MultipartFile multipartFile : files){
            if(multipartFile.isEmpty()){
                return getFailResponse(false, "업로드 실패");
            }
        }

        List<AppFile> result = fileService.addFiles(files, fileType);
        return getSuccessResponse(result, "업로드 성공하였습니다");
    }

    @RequestMapping(value = "/files/{fileKey}/downloads" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileKey,
                                               AppFile appFile) {
        appFile.setFileKey(fileKey);
        return fileService.downloadFile(appFile);
    }
}
