package controller.keyword;

import controller.application.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller.
 *
 * @author skuarch
 */
@Controller
public class AddKeywordModal extends BaseController {

    private static final ModelAndView MAV = new ModelAndView("keyword/addKeywordModal");

    //==========================================================================
    /**
     * method for modal window.
     *
     * @param modalId String
     * @return ModelAndView
     */
    @RequestMapping(value = { "/addKeywordModal" })
    public ModelAndView addkeywordModal(@RequestParam String modalId) {

        MAV.addObject("modalId", modalId);
        return MAV;

    }
}
