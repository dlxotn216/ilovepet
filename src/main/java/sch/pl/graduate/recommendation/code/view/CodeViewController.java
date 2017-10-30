package sch.pl.graduate.recommendation.code.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sch.pl.graduate.recommendation.code.model.Code;
import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.code.service.CodeService;
import sch.pl.graduate.recommendation.common.controller.AbstractViewController;

import java.util.List;

/**
 * Created by taesu on 2017-10-30.
 */
@Controller
public class CodeViewController extends AbstractViewController{

    @Autowired
    private CodeService codeService;

    @GetMapping("/code")
    public String getCodeView(Model model, CodeCriteria codeCriteria) {
        codeCriteria.setSort("codeType");
        codeCriteria.setOrder("ASC");

        List<Code> codes = codeService.getCodes(codeCriteria);
        final Integer totalCount = codeService.getCodesTotalCount(codeCriteria);
        Integer totalPage = totalCount / codeCriteria.getLimit();
        totalPage += (totalCount%codeCriteria.getLimit()) == 0 ? 0 : 1;
        final Integer currentPage = codeCriteria.getPage();

        model.addAttribute("codes", codes);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage==0 ? 1: totalPage);
        model.addAttribute("currentPage", currentPage);

        return getListView(model, "code/codeList");
    }

    @GetMapping("/code/add")
    public String getCodeAddView() {
        return "code/codeAdd";
    }

    @GetMapping("/code/{codeKey}/detail")
    public String getCodeDetailView(Model model, @PathVariable Long codeKey) {
        Code code = codeService.getCodeByCodeKey(codeKey);
        model.addAttribute("code", code);

        return "code/codeDetail";
    }

    @GetMapping("/code/{codeKey}/update")
    public String getCodeUpdateView(Model model, @PathVariable Long codeKey) {
        Code code = codeService.getCodeByCodeKey(codeKey);
        model.addAttribute("code", code);

        return "code/codeUpdate";
    }
}
