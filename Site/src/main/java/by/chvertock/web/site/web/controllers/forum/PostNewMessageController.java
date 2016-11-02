//package by.chvertock.webapp.web.controllers.forum;
//
//import by.chvertock.webapp.model.forum.Message;
//import by.chvertock.webapp.service.forum.ForumService;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Date;
//
///**
// * Created by mad on 6/24/16.
// */
//@Controller
//public class PostNewMessageController {
//
//    @Autowired
//    private ForumService forumService;
//
//    @RequestMapping("forum/post-new-message")
//    public String postNewMessage(@ModelAttribute("message") Message message) {
//
//        if (StringUtils.isBlank(message.getUsername())) {
//            message.setUsername("Anonymous");
//        }
//
//        message.setDate(new Date());
//
//        forumService.addMessage(message);
//
//        return "redirect:/";
//    }
//}
