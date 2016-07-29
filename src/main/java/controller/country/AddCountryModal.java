package controller.country;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller. @author skuarch
 */
@Controller
public class AddCountryModal {

    private static final ModelAndView MAV = new ModelAndView("country/addCountryModal");

    //==========================================================================
    /**
     * view for modal window.
     *
     * @param modalId String
     * @return ModelAndView
     */
    @RequestMapping(value = { "/addCountryModal" })
    public ModelAndView addGenreModal(@RequestParam String modalId) {

        MAV.addObject("modalId", modalId);
        return MAV;

    }

}
