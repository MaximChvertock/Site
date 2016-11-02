//package by.chvertock.webapp.web.controllers.forum;
//
//import by.chvertock.webapp.model.entities.User;
//import by.chvertock.webapp.model.forum.Message;
//import by.chvertock.webapp.service.forum.ForumService;
//import by.chvertock.webapp.service.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
///**
// * Created by mad on 6/24/16.
// */
//@Controller
//public class ShowMessagesController {
//
//    @Autowired
//    private ForumService forumService;
//
//    @RequestMapping("/home")
//    public String showHomePage() {
//
//        return "IndexPage";
//    }
//
//    @ModelAttribute("message")
//    private Message getMessage() {
//        return forumService.message();
//    }
//
//    @ModelAttribute("messageList")
//    private List<Message> getMessageList() {
//        return forumService.getMessageList();
//    }
//}
