package controller.keyword;

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
public class KeywordSelect {

    @Autowired
    private MessageSource messageSource;
    private static final ModelAndView MAV = new ModelAndView("keyword/keywordSelect");
    private JSONArray jsonArrayKeywords;

    //==========================================================================
    @RequestMapping(value = { "/keywordSelect" })
    public ModelAndView genreSelect(Locale locale) {

        try {

            jsonArrayKeywords = RestClientGetAdapter.receive(Constants.API_RADIO_URL + "v1/keyword/get/list");
            MAV.addObject("jsonArrayKeywords", jsonArrayKeywords);

        } catch (Exception e) {
            HandlerExceptionUtil.json(MAV, messageSource, e, getClass(), locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return MAV;

    }

}
