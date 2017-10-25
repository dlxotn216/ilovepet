package sch.pl.graduate.recommendation.notice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.notice.mapper.NoticeMapper;
import sch.pl.graduate.recommendation.notice.model.Notice;
import sch.pl.graduate.recommendation.notice.model.NoticeCriteria;
import sch.pl.graduate.recommendation.notice.service.NoticeService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by taesu on 2017-10-25.
 */
@Service
public class NoticeServiceImpl extends AbstractService implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    
    @Override
    public Integer addNotice(Notice notice) {
        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        Timestamp createdAt = new Timestamp(currentMillis);
        notice.setCreatedAt(createdAt);
        return noticeMapper.addNotice(notice);
    }

    @Override
    public Notice getNoticeByNoticeKey(Long noticeKey) {
        return noticeMapper.getNoticeByNoticeKey(noticeKey);
    }

    @Override
    public Integer getNoticesTotalCount(NoticeCriteria noticeCriteria) {
        return noticeMapper.getNoticesTotalCount(noticeCriteria);
    }

    @Override
    public List<Notice> getNotices(NoticeCriteria noticeCriteria) {
        return noticeMapper.getNotices(noticeCriteria);
    }

    @Override
    public Integer updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public Integer deleteNotice(Notice notice) {
        return noticeMapper.deleteNotice(notice);
    }
}
