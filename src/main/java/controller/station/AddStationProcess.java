package controller.station;

import controller.application.BaseController;
import java.util.Locale;
import model.bean.Station;
import model.logic.Constants;
import model.logic.RestClientPostAdapter;
import model.util.HandlerExceptionUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AddStationProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = { "/addStationProcess" })
    public ModelAndView addStationProcess(@ModelAttribute Station station, Locale locale) {

        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono;

        try {

            jsono = RestClientPostAdapter.sendReceive(Constants.API_RADIO_URL + "v1/station/create", station);            
            
            if (jsono.getInt("code") != 200) {
                jsono.put("error", messageSource.getMessage(HandlerExceptionUtil.chooseBestMessage(jsono.getString("message")), null, locale));                
            }
            
            mav.addObject("json", jsono.toString());            

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, AddStationProcess.class, locale, Constants.DEFAULT_I18N_TEXT_ERROR);
        }

        return mav;

    }

}
