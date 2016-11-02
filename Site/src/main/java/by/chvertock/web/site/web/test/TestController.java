package by.chvertock.web.site.web.test;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.forum.Message;
import by.chvertock.web.site.service.MessageService;
import by.chvertock.web.site.service.role.RoleService;
import by.chvertock.web.site.web.utils.ControllerUtils;


@Controller
public class TestController {
    
    @Autowired
    private MessageService messageService;

    @Autowired
    private RoleService roleService;
    
    @RequestMapping("test-add-new-message")
    public String showTest(){

	
	    Message message = new Message();
	    message.setTimestamp(new Timestamp(System.currentTimeMillis()));
	    message.setText("Сообщение сгенерировано: "+new Date());
	    messageService.save(message);
	    
	    System.out.println(message);
	
        return ControllerUtils.redirect("home");
    }
    
    @RequestMapping("test")
    public ModelAndView test(){
	ModelAndView modelAndView = new ModelAndView("test");
	
	modelAndView.addObject("message", "йцукеенгшгртмии");
	
	return modelAndView;
    }
    
//    @RequestMapping("generate-user-roles") // USER IT METHOD ONLY FOR EMPTY 'role' TABLE
    public String generateUserRoles(){
	roleService.save(Role.ROLE_ANON);
	roleService.save(Role.ROLE_ADMIN);
	roleService.save(Role.ROLE_USER);
	
	return ControllerUtils.redirect("home");
    }
}
