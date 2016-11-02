package by.chvertock.web.site.dao.forum.message.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.forum.message.MessageDao;
import by.chvertock.web.site.model.entities.forum.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable save(Message message) {
	try{
	    return sessionFactory.getCurrentSession().save(message);
	} catch(Exception e){
	    throw new DaoException("Can't save message '" + message + "' to database.", e);
	}
    }

    @Override
    public void update(Message message) {
	try{
	    sessionFactory.getCurrentSession().update(message);
	} catch(Exception e){
	    throw new DaoException("Can't update message '" + message + "' to database.", e);
	}
    }

    @Override
    public void delete(Message message) {
	try{
	    sessionFactory.getCurrentSession().delete(message);
	} catch(Exception e){
	    throw new DaoException("Can't delete message '" + message + "' to database.", e);
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> getMessages() {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createCriteria(Message.class)
                    .list();
        } catch (Exception e) {
            throw new DaoException("Can't get list of messages.", e);
        }
    }

}
