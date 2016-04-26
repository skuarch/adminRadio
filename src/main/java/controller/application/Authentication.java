package controller.application;

import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.User;
import model.logic.Constants;
import model.logic.RestClientPostAdapter;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller.
 *
 * @author skuarch
 */
@Controller
public class Authentication extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(Authentication.class);
    @Autowired
    private HttpSession session;
    private static final String AUTHENTICATED = "authenticated";

    //==========================================================================
    /**
     * do the authentication using restful connection.
     *
     * @param user User
     * @param response HttpServletResponse
     * @return ModelAndView
     */
    @RequestMapping(value = { "authentication", "/authentication" }, method = RequestMethod.POST)
    public ModelAndView authentication(@ModelAttribute User user, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsonObject = new JSONObject();
        HashMap<String, Object> parameters;
        JSONObject jsonObjectResponse;
        String email;
        String password;
        String url = Constants.API_RADIO_URL + "v1/user/authentication";

        try {

            Thread.sleep(Constants.TIME_SLEEP_LOGIN);
            setHeaderNoChache();
            setContentType("application/json");

            if (response == null) {
                jsonObject.append(AUTHENTICATED, false);
                mav.addObject("json", jsonObject);
                return mav;
            }

            if (user.getEmail() == null || user.getEmail().length() < 1 || !user.getEmail().contains("@")) {
                jsonObject.append(AUTHENTICATED, false);
                mav.addObject("json", jsonObject);
                return mav;
            }

            if (user.getPassword() == null || user.getPassword().length() != Constants.PASSWORD_LENGTH) {
                jsonObject.append(AUTHENTICATED, false);
                mav.addObject("json", jsonObject);
                return mav;
            }

            //clean vars
            email = StringEscapeUtils.escapeHtml4(user.getEmail());
            password = StringEscapeUtils.escapeHtml4(user.getPassword());

            //set up request
            parameters = new HashMap<>();
            parameters.put("email", email);
            parameters.put("password", password);

            //Send request and receive response
            jsonObjectResponse = RestClientPostAdapter.sendReceive(url, parameters);

            if (jsonObjectResponse.getString("message").equals("true")) {
                jsonObject.accumulate("authenticated", true);
            } else {
                jsonObject.accumulate("authenticated", false);
            }

            //if response is ok create session
            createSession(user);
            mav.addObject("json", jsonObject);

        } catch (Exception e) {
            LOGGER.error("authentication", e);
            jsonObject.append(AUTHENTICATED, false);
            jsonObject.append("error", e.getMessage());
            mav.addObject("json", jsonObject);
        }

        return mav;
    }

    //==========================================================================
    /**
     * create the session then the authentications is successfully.
     *
     * @param user User
     */
    private void createSession(User user) {
        session.setAttribute("logged", "true");
        session.setAttribute("user", user);
    }

}
