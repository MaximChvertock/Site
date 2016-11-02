package by.chvertock.web.site.web.controllers.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.chvertock.web.site.hibernate.HibernateUserDetails;
import by.chvertock.web.site.hibernate.HibernateUserDetailsService;
import by.chvertock.web.site.model.NewUserForm;
import by.chvertock.web.site.model.NewUserFormValidator;
import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.service.role.RoleService;
import by.chvertock.web.site.service.user.UserService;
import by.chvertock.web.site.service.user.exceptions.UserDuplicateException;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class NewUserController {

    @Autowired
    private NewUserFormValidator newUserFormValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Autowired
    private HibernateUserDetailsService userDetailsService;
    
    @Autowired 
    private AuthenticationManager authenticationManager;
    
    @InitBinder("newUserForm")
    public void init(WebDataBinder binder) {
        binder.setValidator(newUserFormValidator);
    }

    @RequestMapping("new-user")
    public String showNewUserForm() {
        return "authentication/NewUserPage";
    }

    @RequestMapping("create-new-user")
    public ModelAndView createNewUser(
            @ModelAttribute("newUserForm") @Validated NewUserForm newUserForm,
            BindingResult result,
            final RedirectAttributes redirectAttributes
    ) {
        ModelAndView modelAndView = new ModelAndView();
        
        System.out.println(newUserForm);

        if (result.hasErrors()) {
            for (Object object : result.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;

                    String field = fieldError.getField();
                    String message = messageSource.getMessage(fieldError, null);

                    redirectAttributes.addFlashAttribute(field + "Error", message);
                }
            }

            modelAndView.setViewName(ControllerUtils.redirect("/new-user.html"));
            return modelAndView;
        }
       
        // is OK!
        User user = null;
        try{
            String encodedPassword = encoder.encode(newUserForm.getPassword());
            
            Role role = roleService.findByType(Role.ROLE_USER.getType());
            
            user = new User();
            
            user.setName(newUserForm.getName());
            user.setEmail(newUserForm.getEmail());
            user.setPassword(encodedPassword);
            user.getRoles().add(role);
            
            userService.save(user);
            
            System.out.println(user);
        } catch (UserDuplicateException e){   
            
            redirectAttributes.addFlashAttribute("duplicateUserError", "true");
            
            redirectAttributes.addFlashAttribute("name", newUserForm.getName());
            redirectAttributes.addFlashAttribute("email", newUserForm.getEmail());
            redirectAttributes.addFlashAttribute("password", newUserForm.getPassword());
            
            System.out.println("Duplicate: "+user);

            modelAndView.setViewName(ControllerUtils.redirect("/new-user.html"));
            return modelAndView;
        }
        
        
     // perform login authentication
        try {
          UserDetails userDetails = userDetailsService.loadUserByUsername(user.getName());
          UsernamePasswordAuthenticationToken auth = 
        	  new UsernamePasswordAuthenticationToken(
        		  userDetails, 
        		  newUserForm.getPassword(), // use raw password
        		  userDetails.getAuthorities()
        		  );
          authenticationManager.authenticate(auth);
     
          if(auth.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(auth);
          }
        } catch (Exception e) {
            throw new UnknownError(); // TODO: resolve it, please)
        }
        
        
        // Done
        modelAndView.setViewName(ControllerUtils.redirect("/"));
        return modelAndView;
    }

    @ModelAttribute(name = "newUserForm")
    public NewUserForm getNewUserForm() {
        return new NewUserForm();
    }
}
