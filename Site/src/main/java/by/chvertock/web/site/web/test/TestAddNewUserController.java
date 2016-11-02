package by.chvertock.web.site.web.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.service.role.RoleService;
import by.chvertock.web.site.service.user.UserService;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class TestAddNewUserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @RequestMapping("test-add-new-user")
    public String addNewUser(){
	String rawPassword = "1234";
	String encodedPassword = encoder.encode(rawPassword);
	
	User user = new User();
	
	Set<Role> roles = new HashSet<>();
	
	Role roleUser = roleService.saveOrGet(Role.ROLE_USER);

	roles.add(roleUser);
	
	user.setName("User_"+System.currentTimeMillis());
	user.setEmail(user.getName()+"@mail.com");
	user.setPassword(encodedPassword);
	user.setRoles(roles);
	
	userService.save(user);
	
	return ControllerUtils.redirect("home");
    }
   
}
