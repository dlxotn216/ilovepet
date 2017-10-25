package sch.pl.graduate.recommendation.notice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.notice.model.Notice;
import sch.pl.graduate.recommendation.notice.model.NoticeCriteria;

import java.util.List;

/**
 * Created by taesu on 2017-10-25.
 */
@Repository
@Mapper
public interface NoticeMapper {
    Integer addNotice(Notice notice);

    Notice getNoticeByNoticeKey(Long noticeKey);

    Integer getNoticesTotalCount(NoticeCriteria noticeCriteria);

    List<Notice> getNotices(NoticeCriteria noticeCriteria);

    Integer updateNotice(Notice notice);

    Integer deleteNotice(Notice notice);
}
