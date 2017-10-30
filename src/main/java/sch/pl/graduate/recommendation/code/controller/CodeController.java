package sch.pl.graduate.recommendation.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sch.pl.graduate.recommendation.code.model.Code;
import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.code.service.CodeService;
import sch.pl.graduate.recommendation.common.controller.AbstractController;

import java.util.List;

/**
 * Created by taesu on 2017-10-30.
 */
@RestController
public class CodeController extends AbstractController {

    @Autowired
    private CodeService codeService;

    @PostMapping("/codes")
    public ResponseEntity addCode(@RequestBody Code code){
        Integer result = codeService.addCode(code);
        return getSuccessResponse(result, "생성하였습니다");
    }

    @GetMapping("/codes")
    public ResponseEntity getCodes(CodeCriteria codeCriteria){
        List<Code> codes = codeService.getCodes(codeCriteria);
        final Integer totalCount = codeService.getCodesTotalCount(codeCriteria);
        Integer totalPage = totalCount / codeCriteria.getLimit();
        totalPage += (totalCount%codeCriteria.getLimit()) == 0 ? 0 : 1;
        final Integer currentPage = codeCriteria.getPage();

        return getSuccessResponse(codes, totalCount, totalPage, currentPage, "조회 완료하였습니다");
    }

    @GetMapping("/codes/{codeKey}")
    public ResponseEntity getCode(@PathVariable Long codeKey){
        Code code = codeService.getCodeByCodeKey(codeKey);
        return getSuccessResponse(code, "성공");
    }

    @PutMapping("/codes/{codeKey}")
    public ResponseEntity updateCode(@PathVariable Long codeKey, @RequestBody Code code){
        code.setCodeKey(codeKey);
        Integer result = codeService.updateCode(code);
        return getSuccessResponse(result, "수정 성공");
    }

    @DeleteMapping("/codes/{codeKey}")
    public ResponseEntity deleteCode(@PathVariable Long codeKey){
        Code code = new Code();
        code.setCodeKey(codeKey);
        Integer result = codeService.deleteCode(code);
        return getSuccessResponse(result, "삭제 성공");
    }
}
