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
 * controller.
 *
 * @author skuarch
 */
@Controller
public class AddStation extends BaseController {

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    /**
     * add new station into db.
     *
     * @param locale Locale
     * @return ModelAndView
     */
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
            jsonArrayGenres = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/genres/" + locale);
            mav.addObject("jsonArrayGenres", jsonArrayGenres);

            //get languages
            jsonArrayLanguages = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/languages/" + locale);
            mav.addObject("jsonArrayLanguages", jsonArrayLanguages);

            //get countries
            jsonArrayCountries = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/countries/" + locale);
            mav.addObject("jsonArrayCountries", jsonArrayCountries);
            
        } catch (Exception e) {
            //HandlerExceptionUtil.json(mav, messageSource, e, getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
            HandlerExceptionUtil.alert(mav, messageSource, e, this.getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return mav;

    }

}
