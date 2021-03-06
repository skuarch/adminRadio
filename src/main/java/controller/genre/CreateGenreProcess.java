package controller.genre;

import controller.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import model.logic.Constants;
import model.logic.RestClientPostAdapter;
import model.persistence.Genre;
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
public class CreateGenreProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final ModelAndView MAV = new ModelAndView("application/json");

    //==========================================================================
    /**
     * create a new genre in the db.
     *
     * @param genre Genre
     * @param locale Locale
     * @return ModelAndView
     */
    @RequestMapping(value = { "/createGenreProcess" }, method = RequestMethod.POST)
    public ModelAndView createGenre(@ModelAttribute Genre genre, Locale locale) {

        if(genre == null || genre.getNameEnglish() == null){
            throw new IllegalArgumentException("genre is null");
        }
        
        Map<String, Object> parameters;
        JSONObject jsonResponse;

        try {

            parameters = new HashMap<>();
            parameters.put("nameEnglish", genre.getNameEnglish().substring(0, 1).toUpperCase(locale) + genre.getNameEnglish().substring(1));
            parameters.put("nameSpanish", genre.getNameSpanish().substring(0, 1).toUpperCase(locale) + genre.getNameSpanish().substring(1));
            jsonResponse = RestClientPostAdapter.sendReceive(Constants.API_RADIO_URL + "v1/genre/create", parameters);

            if (jsonResponse.getString("message").equalsIgnoreCase("genre already exits")) {
                jsonResponse.append("error", messageSource.getMessage("text51", null, locale));
            }

            MAV.addObject("json", jsonResponse.toString());

        } catch (Exception e) {
            HandlerExceptionUtil.json(MAV, messageSource, e, getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return MAV;

    }

}
