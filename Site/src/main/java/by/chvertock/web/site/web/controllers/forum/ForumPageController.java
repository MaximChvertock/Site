package by.chvertock.web.site.web.controllers.forum;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.chvertock.web.site.hibernate.HibernateUserDetails;
import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.model.entities.forum.Message;
import by.chvertock.web.site.model.entities.forum.Topic;
import by.chvertock.web.site.model.forum.NewMessageForm;
import by.chvertock.web.site.model.forum.NewTopicForm;
import by.chvertock.web.site.service.MessageService;
import by.chvertock.web.site.service.forum.ForumService;
import by.chvertock.web.site.service.user.UserService;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class ForumPageController {

    @Autowired
    private MessageService messageService;
    
    @Autowired
    private ForumService forumService;
    
    @Autowired
    private UserService userService;
    
    
    @RequestMapping("forum")
    public ModelAndView showForumPage(){
	ModelAndView modelAndView = new ModelAndView("forum/ForumPage");
	
	List<Topic> topics = forumService.getTopics();
	
	modelAndView.addObject("topics", topics);
	
	
	return modelAndView;
    }
    
    @RequestMapping("forum/new-topic")
    public ModelAndView showNewTopicPage(){
	ModelAndView modelAndView = new ModelAndView("forum/NewTopicPage");
	return modelAndView;
    }
    
    @RequestMapping("forum/topic/{topicId}")
    public ModelAndView showTopicPage(@PathVariable("topicId") long topicId){
	ModelAndView modelAndView = new ModelAndView("forum/TopicPage");
	
	Topic topic = forumService.getTopicById(topicId);
	
	modelAndView.addObject("topicId", topic.getId());
	modelAndView.addObject("topicTitle", topic.getTitle());
	modelAndView.addObject("messages", topic.getSortedMessages());
	
	
	
	return modelAndView;
    }
    
    @RequestMapping("action/addNewTopic")
    public String addNewTopic(@ModelAttribute("newTopicForm") NewTopicForm newTopicForm){
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	User author = userService.findByName(auth.getName());

	Timestamp timestamp = getTimestamp();


	Topic topic = new Topic();
	topic.setAuthor(author);
	topic.setTitle(newTopicForm.getTitle());
	topic.setTimestamp(timestamp);
	
	// first message
	Message message = new Message();
	message.setAuthor(author);
	message.setCaption(newTopicForm.getTitle());
	message.setText(newTopicForm.getText());
	message.setTimestamp(timestamp);
	topic.getMessages().add(message);

	System.out.println(topic);
	
	long topicId = (long)forumService.save(topic);
	
	
	return ControllerUtils.redirect("/forum/topic/"+topicId);
    }
    
    private Timestamp getTimestamp() {
	return new Timestamp(System.currentTimeMillis());
    }

    @RequestMapping("action/addNewMessage")
    public String addNewMessage(@ModelAttribute("newMessageForm") NewMessageForm newMessageForm){
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	User author = userService.findByName(auth.getName());
	
	Topic topic = forumService.getTopicById(newMessageForm.getTopicId());
	
	Message message = new Message();
	message.setAuthor(author);
	message.setCaption(newMessageForm.getTitle());
	message.setText(newMessageForm.getText());
	message.setTimestamp(getTimestamp());
	
//	long messageId = messageService.save(message);
//	message.setId(messageId);
	
	topic.getMessages().add(message);
	
	forumService.update(topic);
	
	return ControllerUtils.redirect("/forum/topic/"+newMessageForm.getTopicId());
    }
    
    @ModelAttribute("newMessageForm")
    public NewMessageForm getNewMessageForm(){
	return new NewMessageForm();
    }
    
    @ModelAttribute("newTopicForm")
    public NewTopicForm getNewTopicForm(){
	return new NewTopicForm();
    }
}
