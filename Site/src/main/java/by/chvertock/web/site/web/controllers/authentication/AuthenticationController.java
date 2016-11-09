package by.chvertock.web.site.web.controllers.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.chvertock.web.site.model.LoginForm;
import by.chvertock.web.site.service.SecurityService;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class AuthenticationController {
    
    
    @Autowired 
    private SecurityService securityService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
	
        if (error != null)
            model.addAttribute("authenticationError", "true");

        if (logout != null)
            model.addAttribute("loggedOut", "true");

        return "authentication/LoginFormPage";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        securityService.logout(request, response);

        return ControllerUtils.redirect("/login?logout");
    }
    
    @ModelAttribute("loginForm")
    public LoginForm getLoginForm(){
	LoginForm loginForm = new LoginForm();
	
//	loginForm.setUsername("Default Username");
//	loginForm.setPassword("Default Password");
	
	return loginForm;
    }
}
