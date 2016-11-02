package by.chvertock.web.site.service.forum;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.forum.topic.TopicDao;
import by.chvertock.web.site.model.entities.forum.Topic;
import by.chvertock.web.site.service.exceptions.ServiceException;

@Service
public class ForumService {
    
    @Autowired
    private TopicDao topicDao;
    
    @Transactional
    public long save(Topic topic){
	try{
	    return (long)topicDao.save(topic);
	} catch (DaoException e){
	    throw new ServiceException();
	}
    }
    
    @Transactional
    public void update(Topic topic) {
	try{
	    topicDao.update(topic);
	} catch (DaoException e){
	    //throw new ServiceException();
	    e.printStackTrace();
	}
    }
    
    @Transactional
    public Topic getTopicById(long id){
	try{
	    return topicDao.getTopicById(id);
	} catch (DaoException e){
	    throw new ServiceException();
	}
    }
    
    @Transactional
    public List<Topic> getTopics(){
	try{
	    return topicDao.getTopics();
	} catch (DaoException e){
	    throw new ServiceException();
	}
    }
}




