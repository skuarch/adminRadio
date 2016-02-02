package controller.application;

import model.logic.I18N;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class ScriptI18N extends BaseController {

    //==========================================================================
    /**
     * create a Javascript file at runtime to share messages i18n.
     *
     * @return ModelAndView
     */
    @RequestMapping(value = { "scriptI18N", "/scripI18N" })
    public ModelAndView scriptI18N() {
        setContentType("text/javascript");
        ModelAndView mav = new ModelAndView("application/scriptI18N");
        mav.addObject("arrayList", I18N.getArrayList());
        return mav;

    }

}
