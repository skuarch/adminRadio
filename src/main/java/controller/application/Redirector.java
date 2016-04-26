package controller.application;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller.
 *
 * @author skuarch
 */
@Controller
public class Redirector extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(Redirector.class);

    //==========================================================================
    /**
     * this method redirect and save all the url parameters in session.
     *
     * @param request HttpdServletRequest
     * @param session HttpSession
     * @return ModelAndView
     */
    @RequestMapping(value = { "/redirector", "redirector" })
    public ModelAndView redirect(HttpServletRequest request, HttpSession session) {

        ModelAndView modelAndView;

        try {

            String url = request.getParameter("url");
            Map<String, String[]> parameters = request.getParameterMap();

            parameters.entrySet().stream().forEach(entrySet -> {
                session.setAttribute(entrySet.getKey(), entrySet.getValue()[0]);
            });

            modelAndView = new ModelAndView("redirect:" + url);

        } catch (Exception e) {
            LOGGER.error("Redirector", e);
            modelAndView = new ModelAndView("redirect:systemWelcome.html");
        }

        return modelAndView;
    }

}
