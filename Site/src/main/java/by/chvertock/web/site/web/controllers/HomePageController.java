package by.chvertock.web.site.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping("home")
    public String showHomePage(){
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = auth.getName();
	
	Object credentials = auth.getCredentials();
	
	System.out.println(username);
	System.out.println(auth.getAuthorities());
	System.out.println(credentials);
	
        return "HomePage";
    }
}
