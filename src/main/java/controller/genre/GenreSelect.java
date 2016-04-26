package controller.genre;

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
 * @Controller.
 * @author skuarch
 */
@Controller
public class GenreSelect {

    @Autowired
    private MessageSource messageSource;
    private static final ModelAndView MAV = new ModelAndView("genre/genreSelect");
    private JSONArray jsonArrayGenres;

    //==========================================================================
    /**
     * create a select (HTML) for genre.
     * @param locale Locale
     * @return ModelAndView
     */
    @RequestMapping(value = { "/genreSelect" })
    public ModelAndView genreSelect(Locale locale) {

        try {
            
            jsonArrayGenres = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/genre/get/list");
            MAV.clear();
            MAV.addObject("jsonArrayGenres", jsonArrayGenres);

        } catch (Exception e) {
            HandlerExceptionUtil.json(MAV, messageSource, e, getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return MAV;

    }

}
