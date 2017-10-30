package sch.pl.graduate.recommendation.notice.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sch.pl.graduate.recommendation.common.controller.AbstractViewController;
import sch.pl.graduate.recommendation.notice.model.Notice;
import sch.pl.graduate.recommendation.notice.model.NoticeCriteria;
import sch.pl.graduate.recommendation.notice.service.NoticeService;

import java.util.List;

/**
 * Created by taesu on 2017-10-25.
 */
@Controller
public class NoticeViewController extends AbstractViewController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice")
    public String getNoticeView(Model model, NoticeCriteria noticeCriteria) {
        List<Notice> notices = noticeService.getNotices(noticeCriteria);
        final Integer totalCount = noticeService.getNoticesTotalCount(noticeCriteria);
        Integer totalPage = totalCount / noticeCriteria.getLimit();
        totalPage += (totalCount%noticeCriteria.getLimit()) == 0 ? 0 : 1;
        final Integer currentPage = noticeCriteria.getPage();

        model.addAttribute("notices", notices);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage==0 ? 1: totalPage);
        model.addAttribute("currentPage", currentPage);

        return getListView(model, "notice/noticeList");
    }

    @GetMapping("/notice/add")
    public String getNoticeAddView() {
        return "notice/noticeAdd";
    }

    @GetMapping("/notice/{noticeKey}/detail")
    public String getNoticeDetailView(Model model, @PathVariable Long noticeKey) {
        Notice notice = noticeService.getNoticeByNoticeKey(noticeKey);
        model.addAttribute("notice", notice);

        return "notice/noticeDetail";
    }

    @GetMapping("/notice/{noticeKey}/update")
    public String getNoticeUpdateView(Model model, @PathVariable Long noticeKey) {
        Notice notice = noticeService.getNoticeByNoticeKey(noticeKey);
        model.addAttribute("notice", notice);

        return "notice/noticeUpdate";
    }
}
