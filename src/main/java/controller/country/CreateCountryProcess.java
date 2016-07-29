package controller.country;

import controller.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import model.bean.Country;
import model.logic.Constants;
import model.logic.RestClientPostAdapter;
import model.util.HandlerExceptionUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller.
 *
 * @author skuarch
 */
@Controller
public class CreateCountryProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final ModelAndView MAV = new ModelAndView("application/json");

    //==========================================================================
    /**
     * create a new country in the db.
     *
     * @param country Country
     * @param locale Locale
     * @return ModelAndView
     */
    @RequestMapping(value = { "/createCountryProcess" }, method = RequestMethod.POST)
    public ModelAndView createGenre(@ModelAttribute Country country, Locale locale) {

        Map<String, Object> parameters;
        JSONObject jsonResponse;

        try {

            parameters = new HashMap<>();
            parameters.put("name", country.getName().substring(0, 1).toUpperCase(locale) + country.getName().substring(1));
            jsonResponse = RestClientPostAdapter.sendReceive(Constants.API_RADIO_URL + "v1/country/create", parameters);

            if (jsonResponse.getString("message").equalsIgnoreCase("country already exits")) {
                jsonResponse.append("error", messageSource.getMessage("text71", null, locale));
            }

            MAV.addObject("json", jsonResponse.toString());

        } catch (Exception e) {
            HandlerExceptionUtil.json(MAV, messageSource, e, getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return MAV;

    }

}
