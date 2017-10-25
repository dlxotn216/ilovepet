package sch.pl.graduate.recommendation.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.notice.model.Notice;
import sch.pl.graduate.recommendation.notice.model.NoticeCriteria;
import sch.pl.graduate.recommendation.notice.service.NoticeService;
import sch.pl.graduate.recommendation.pet.model.Pet;

import java.util.List;

/**
 * Created by taesu on 2017-10-25.
 */
@RestController
public class NoticeController extends AbstractController{

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/notices")
    public ResponseEntity addNotice(@RequestBody Notice notice){
        Integer result = noticeService.addNotice(notice);
        return getSuccessResponse(result, "생성하였습니다");
    }

    @GetMapping("/notices")
    public ResponseEntity getNotices(NoticeCriteria noticeCriteria){
        List<Notice> notices = noticeService.getNotices(noticeCriteria);
        final Integer totalCount = noticeService.getNoticesTotalCount(noticeCriteria);
        final Integer totalPage = totalCount / noticeCriteria.getLimit();
        final Integer currentPage = noticeCriteria.getPage();

        return getSuccessResponse(notices, totalCount, totalPage, currentPage, "조회 완료하였습니다");
    }

    @GetMapping("/notices/{noticeKey}")
    public ResponseEntity getNotice(@PathVariable Long noticeKey){
        Notice notice = noticeService.getNoticeByNoticeKey(noticeKey);
        return getSuccessResponse(notice, "성공");
    }

    @PutMapping("/notices/{noticeKey}")
    public ResponseEntity updateNotice(@PathVariable Long noticeKey, @RequestBody Notice notice){
        notice.setNoticeKey(noticeKey);
        Integer result = noticeService.updateNotice(notice);
        return getSuccessResponse(result, "수정 성공");
    }

    @DeleteMapping("/notices/{noticeKey}")
    public ResponseEntity deleteNotice(@PathVariable Long noticeKey){
        Notice notice = new Notice();
        notice.setNoticeKey(noticeKey);
        Integer result = noticeService.deleteNotice(notice);
        return getSuccessResponse(result, "삭제 성공");
    }
}
