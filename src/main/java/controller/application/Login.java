package controller.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller.
 *
 * @author skuarch
 */
@Controller
public class Login extends BaseController {

    //==========================================================================
    /**
     * this is the first controller that is called.
     *
     * @return String
     */
    @RequestMapping(value = { "/", "/login" })
    public String index() {

        setContentType("text/html; charset=UTF-8");
        setCharacterEncoding("UTF-8");
        setHeaderNoChache();

        return "application/login";
    }

}
