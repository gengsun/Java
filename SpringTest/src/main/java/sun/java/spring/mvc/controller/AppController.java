package sun.java.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sun on 12/11/15.
 */

@Controller
@RequestMapping("/hello")
public class AppController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap modelMap)
    {
        modelMap.addAttribute("message", "Sun's Spring MVC Hello World Example.");
        return "hello";
    }
}
