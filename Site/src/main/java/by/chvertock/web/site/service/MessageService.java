package by.chvertock.web.site.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.forum.message.MessageDao;
import by.chvertock.web.site.model.entities.forum.Message;
import by.chvertock.web.site.service.exceptions.ServiceException;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;
    
    @Transactional
    public long save(Message message){
	try{
	    return (long)messageDao.save(message);
	} catch(DaoException e){
	    throw new ServiceException(e);
	}
    }
    
    @Transactional
    public List<Message> getMessages(){
	return messageDao.getMessages();
    }
}
