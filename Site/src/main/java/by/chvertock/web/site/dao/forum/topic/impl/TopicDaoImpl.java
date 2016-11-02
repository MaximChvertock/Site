package by.chvertock.web.site.dao.forum.topic.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.forum.topic.TopicDao;
import by.chvertock.web.site.model.entities.forum.Topic;

@Repository
public class TopicDaoImpl implements TopicDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable save(Topic topic) {
	try{
	    return sessionFactory.getCurrentSession().save(topic);
	} catch(Exception e){
//	    throw new DaoException("Can't save topic '" + topic + "' to database.", e);
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public void update(Topic topic) {
	try{
	    sessionFactory.getCurrentSession().update(topic);
	} catch(Exception e){
	    throw new DaoException("Can't update topic '" + topic + "' to database.", e);
	}
    }

    @Override
    public void delete(Topic topic) {
	try{
	    sessionFactory.getCurrentSession().delete(topic);
	} catch(Exception e){
	    throw new DaoException("Can't delete topic '" + topic + "' to database.", e);
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Topic> getTopics() {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createCriteria(Topic.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .addOrder(Order.asc("timestamp"))
                    .list();
        } catch (Exception e) {
            throw new DaoException("Can't get list of topics.", e);
        }
    }

    @Override
    public Topic getTopicById(long id) {
	try{
	    return (Topic)sessionFactory
		    .getCurrentSession()
		    .get(Topic.class, id);
	} catch (Exception e) {
            throw new DaoException("Can't get topic by id="+id, e);
        }
    }

}
