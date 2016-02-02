package controller.station;

import controller.application.BaseController;
import java.util.Locale;
import model.logic.Constants;
import model.logic.RestClientGetAdapter;
import model.util.HandlerExceptionUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AddStation extends BaseController {

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = { "/addStation" })
    public ModelAndView addStation(Locale locale) {

        ModelAndView mav = new ModelAndView("station/addStation");
        JSONArray jsonArrayKeywords;
        JSONArray jsonArrayGenres;
        JSONArray jsonArrayLanguages;
        JSONArray jsonArrayCountries;

        try {

            //get keywords
            jsonArrayKeywords = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/keyword/get/list");
            mav.addObject("jsonArrayKeywords", jsonArrayKeywords);

            //get genres
            jsonArrayGenres = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/genre/get/list");
            mav.addObject("jsonArrayGenres", jsonArrayGenres);

            //get languages
            jsonArrayLanguages = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/language/get/list");
            mav.addObject("jsonArrayLanguages", jsonArrayLanguages);

            //get countries
            jsonArrayCountries = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/country/get/list");
            mav.addObject("jsonArrayCountries", jsonArrayCountries);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return mav;

    }

}
