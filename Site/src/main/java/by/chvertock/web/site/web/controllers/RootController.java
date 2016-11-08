package by.chvertock.web.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class RootController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect(){
	return ControllerUtils.redirect("home");
    }
}
