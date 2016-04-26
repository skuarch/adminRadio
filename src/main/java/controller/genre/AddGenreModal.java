package controller.genre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller. @author skuarch
 */
@Controller
public class AddGenreModal {

    private static final ModelAndView MAV = new ModelAndView("genre/addGenreModal");

    //==========================================================================
    /**
     * view for modal window.
     *
     * @param modalId String
     * @return ModelAndView
     */
    @RequestMapping(value = { "/addGenreModal" })
    public ModelAndView addGenreModal(@RequestParam String modalId) {

        MAV.addObject("modalId", modalId);
        return MAV;

    }

}
