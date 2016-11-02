package by.chvertock.web.site.web.controllers.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.chvertock.web.site.model.contact.ContactMessageForm;
import by.chvertock.web.site.service.email.EmailService;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class SendContactMessageController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("sendContactMessage")
    public String sendMessage(@ModelAttribute ContactMessageForm form){
        emailService.sendContactMessage(form);
        return ControllerUtils.redirect("home");
    }
}
