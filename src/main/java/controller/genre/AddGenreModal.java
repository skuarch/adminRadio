package controller.genre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AddGenreModal {
    
    private static final ModelAndView mav = new ModelAndView("genre/addGenreModal");
    
    @RequestMapping(value = {"/addGenreModal"})
    public ModelAndView addGenreModal(@RequestParam String modalId){    
        
        mav.addObject("modalId", modalId);
        return mav;  
    
    }
    
}
