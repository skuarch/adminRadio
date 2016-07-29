package model.util;

import java.util.Locale;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

/**
 * class helper to handle the exceptions.
 *
 * @author skuarch
 */
public final class HandlerExceptionUtil {

    //==========================================================================
    /**
     * this class doesn't need a public constructor.
     */
    private HandlerExceptionUtil() {
    } // end HandlerExceptionUtil

    //==========================================================================
    /**
     * this method set the ModelAnview for handle the exception as Javascript.
     *
     * @param mav ModelAndView
     * @param messageSource MessageSource
     * @param exception Exception
     * @param logger Logger
     * @param locale Locale
     * @param textNumber String
     */
    public static void alert(ModelAndView mav, MessageSource messageSource, Exception exception, Logger logger, Locale locale, String textNumber) {

        logger.error(" error ", exception);
        mav.addObject("js", "alertify.error(\'" + messageSource.getMessage(textNumber, null, locale) + "\')");

    } // end handleExceptionAlert

    //==========================================================================
    /**
     * this method set the ModelAnview for handle the exception as Javascript.
     *
     * @param mav ModelAndView
     * @param messageSource MessageSource
     * @param exception Exception
     * @param c Class
     * @param locale Locale
     * @param textNumber String
     */
    public static void alert(ModelAndView mav, MessageSource messageSource, Exception exception, Class<?> c, Locale locale, String textNumber) {

        Logger logger = Logger.getLogger(c);
        logger.error(" error ", exception);
        mav.addObject("js", "alertify.error(\'" + messageSource.getMessage(textNumber, null, locale) + "\')");

    } // end handleExceptionAlert

    //==========================================================================
    /**
     * this method set the ModelAnview for handle the exception as JSON.
     *
     * @param mav ModelAndView
     * @param messageSource MessageSource
     * @param exception Exception
     * @param c Class
     * @param locale Locale
     * @param textNumber String
     */
    public static void json(ModelAndView mav, MessageSource messageSource, Exception exception, Class<?> c, Locale locale, String textNumber) {

        Logger logger = Logger.getLogger(c);
        logger.error(" error ", exception);
        JSONObject jsono = new JSONObject();

        if (exception.getMessage() != null) {
            jsono.append("error", "error: " + exception.getMessage());
        } else {
            jsono.append("error", messageSource.getMessage(textNumber, null, locale));
        }

        if (mav == null) {
            mav = new ModelAndView("aplication/json");
        }

        mav.addObject("json", jsono.toString());

    } // end handleExceptionJson

    //==========================================================================
    /**
     * simple switch to choose the best message.
     *
     * @param message message
     * @return String
     */
    public static String chooseBestMessage(String message) {

        String text;

        switch (message) {
            case "":
                text = "text65";
                break;
            case "internal server error":
                text = "text60";
                break;
            case "station already exist":
                text = "text58";
                break;
            case "keyword already exists":
                text = "text57";
                break;
            default:
                text = "text65";
                break;
        }

        return text;

    }

} // end class
