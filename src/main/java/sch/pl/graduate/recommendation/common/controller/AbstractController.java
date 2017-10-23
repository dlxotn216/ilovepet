package sch.pl.graduate.recommendation.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taesu on 2017-10-15.
 */
@Controller
public class AbstractController {
    protected ResponseEntity getSuccessResponse(Object result, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("result", result);
        body.put("status", true);
        body.put("message", message);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    protected ResponseEntity getSuccessResponse(Object result, Integer totalCount, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("result", result);
        body.put("totalCount", totalCount);
        body.put("status", true);
        body.put("message", message);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    protected ResponseEntity getSuccessResponse(Object result, Integer totalCount, Integer totalPage, Integer currentPage, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("result", result);
        body.put("totalCount", totalCount);
        body.put("totalPage", totalPage);
        body.put("currentPage", currentPage);
        body.put("status", true);
        body.put("message", message);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    protected ResponseEntity getFailResponse(Object result, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("result", result);
        body.put("status", false);
        body.put("message", message);

        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
}
