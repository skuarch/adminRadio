package controller.keyword;

import controller.application.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AddKeywordModal extends BaseController {

    private static final ModelAndView mav = new ModelAndView("keyword/addKeywordModal");

    @RequestMapping(value = {"/addKeywordModal"})
    public ModelAndView addkeywordModal(@RequestParam String modalId) {

        mav.addObject("modalId", modalId);
        return mav;

    }
}
