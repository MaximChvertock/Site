package by.chvertock.web.site.web.controllers.authentication;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.chvertock.web.site.model.LoginForm;
import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.service.user.UserService;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class AuthenticationController {
    
    @Autowired
    private UserService userService;
    
    @Autowired 
    private AuthenticationManager authenticationManager;

//    @RequestMapping("/login")
//    public String showAuthenticationPage() {
//        return "authentication/LoginFormPage";
//    }
    
//    @RequestMapping("action/checkLoginForm")
//    public String checkLoginForm( @ModelAttribute("loginForm") LoginForm loginForm) {
//	
//	User user = userService.findByName(loginForm.getUsername());
//	
//	System.out.println(user);
//	
//	Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
//        for (Role role : user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getType().name()));
//        }
//	
//	org.springframework.security.core.userdetails.User principal =
//		new org.springframework.security.core.userdetails.User(
//			user.getName(),
//			user.getPassword(),
//			authorities
//	);
//	
//	UsernamePasswordAuthenticationToken auth =
//		new UsernamePasswordAuthenticationToken(
//			principal,
//			loginForm.getPassword(), // use raw password
//			authorities
//			);
//	authenticationManager.authenticate(auth);
//     
//	if(auth.isAuthenticated()) {
//	    SecurityContextHolder.getContext().setAuthentication(auth);
//	}
//	
//        return ControllerUtils.redirect("/login");
//    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return ControllerUtils.redirect("/login?logout");
    }
    
    @ModelAttribute("loginForm")
    public LoginForm getLoginForm(){
	return new LoginForm();
    }
}
