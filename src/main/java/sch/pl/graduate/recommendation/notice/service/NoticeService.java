package sch.pl.graduate.recommendation.notice.service;

import sch.pl.graduate.recommendation.notice.model.Notice;
import sch.pl.graduate.recommendation.notice.model.NoticeCriteria;

import java.util.List;

/**
 * Created by taesu on 2017-10-25.
 */
public interface NoticeService {
    Integer addNotice(Notice notice);

    Notice getNoticeByNoticeKey(Long noticeKey);

    Integer getNoticesTotalCount(NoticeCriteria noticeCriteria);

    List<Notice> getNotices(NoticeCriteria noticeCriteria);

    Integer updateNotice(Notice notice);

    Integer deleteNotice(Notice notice);
}
