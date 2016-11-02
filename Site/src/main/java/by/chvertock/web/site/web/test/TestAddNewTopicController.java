package by.chvertock.web.site.web.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.model.entities.forum.Message;
import by.chvertock.web.site.model.entities.forum.Topic;
import by.chvertock.web.site.service.forum.ForumService;
import by.chvertock.web.site.service.user.UserService;
import by.chvertock.web.site.web.utils.ControllerUtils;

@Controller
public class TestAddNewTopicController {

    public static final String placeholder = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ForumService forumService;
    
    @RequestMapping("test-add-new-topic")
    public String addNewTopic(){
	Random random = new Random();
	long startTime = System.currentTimeMillis();
	
	
	List<User> users = userService.getUsers();
	User author = users.get(random.nextInt(users.size()));
	
	Message message = new Message();
	
	// first message
	message.setAuthor(author);
	message.setCaption("MESSAGE_CAPTION");
	message.setText(placeholder);
	message.setTimestamp(new Timestamp(startTime));
	
	Topic topic = new Topic();
	
	topic.setAuthor(author);
	topic.setTitle("Topic_"+startTime);
	topic.setTimestamp(new Timestamp(startTime));
	topic.getMessages().add(message);
	
	
	// messages of topic
	for(int i = 0; i < random.nextInt(20); ++i){

	    author = users.get(random.nextInt(users.size()));
	    
	    message = new Message();
	    
	    message.setAuthor(author);
	    message.setCaption("MESSAGE_CAPTION");
	    message.setText(placeholder);
	    message.setTimestamp(new Timestamp(startTime+i*random.nextInt(1000000)));
	    
	    topic .getMessages().add(message);
	}
	
	System.out.println(topic);
	
	long topicId = (long)forumService.save(topic);
	
	return ControllerUtils.redirect("/forum/topic/"+topicId);
    }

}
