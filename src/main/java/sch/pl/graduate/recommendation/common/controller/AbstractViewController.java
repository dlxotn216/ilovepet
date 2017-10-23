/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.common.controller;

import org.springframework.ui.Model;
import sch.pl.graduate.recommendation.common.model.AbstractCriteria;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
public class AbstractViewController {
    protected String getListView(Model model, String viewName){
        model.addAttribute("defaultLimit", AbstractCriteria.DEFAULT_LIMIT);
        model.addAttribute("defaultOffset", AbstractCriteria.DEFAULT_OFFSET);
        model.addAttribute("defaultPage", AbstractCriteria.DEFAULT_PAGE);
        return viewName;
    }
}
