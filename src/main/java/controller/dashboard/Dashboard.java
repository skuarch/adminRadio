package controller.dashboard;

import controller.application.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller. @author skuarch
 */
@Controller
public class Dashboard extends BaseController {

    //==========================================================================
    /**
     * show dashBoard.
     *
     * @param mav ModelAndView
     * @return ModelAndView
     */
    @RequestMapping(value = { "dashboard", "/dashboard" })
    public ModelAndView showDashboard(ModelAndView mav) {
        setHeaderNoChache();
        mav.setViewName("dashboard/index");
        return mav;
    }

}
