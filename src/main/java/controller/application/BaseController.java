package controller.application;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * all the controllers should extend from this class.
 * @author skuarch
 */
public class BaseController {

    private static final Logger LOGGER = Logger.getLogger(BaseController.class);

    // ==========================================================================
    /**
     * set content type of the request.
     *
     * @param contentType String
     */
    protected final void setContentType(String contentType) {

        if (contentType == null || contentType.length() < 1) {
            throw new IllegalArgumentException("contentType is null or empty");
        }

        try {

            HttpServletResponse response = getResponse();

            if (response != null) {
                response.setContentType(contentType + ";charset=UTF-8");
            }

        } catch (Exception e) {
            LOGGER.error("BaseController.setContentType()", e);
        }

    }

    // ==========================================================================
    /**
     * avoid cache in the current request.
     */
    protected final void setHeaderNoChache() {

        try {

            HttpServletResponse response = getResponse();

            if (response != null) {
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
            }

        } catch (Exception e) {
            LOGGER.error("BaseController.setHeaderNoChache()", e);
        }

    }

    // ==========================================================================
    /**
     * get the response to the request.
     *
     * @return HttpServletResponse or null
     */
    private HttpServletResponse getResponse() {

        HttpServletResponse response = null;

        try {

            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

            if (requestAttributes != null) {
                response = ((ServletRequestAttributes) requestAttributes).getResponse();
            }

        } catch (Exception e) {
            LOGGER.error("BaseController.getResponse()", e);
        }

        return response;

    }

    //==========================================================================
    /**
     * setter.
     *
     * @param charset String
     */
    public void setCharacterEncoding(String charset) {
        getResponse().setCharacterEncoding(charset);
    }

}
