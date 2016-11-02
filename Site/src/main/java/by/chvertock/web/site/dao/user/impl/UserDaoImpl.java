package by.chvertock.web.site.dao.user.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.user.UserDao;
import by.chvertock.web.site.model.entities.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
	} catch (Exception e) {
            throw new DaoException("Can't save user '" + user + "' to database.", e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findByName(String name) {
        try {
            return (User) sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("name", name))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException("Can't find user by name='" + name + "'.", e);
        }
    }

    @Override
    public User findByEmail(String email){
	try {
            return (User) sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("email", email))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException("Can't find user by email='" + email + "'.", e);
        }
    }
    
    @Override
    public User findByNameAndEmail(String name, String email){
	try {
            return (User) sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("name", name))
                    .add(Restrictions.eq("email", email))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException("Can't find user by name='" + name + "' and email='" + email + "'.", e);
        }
    }
    
    @Override
    public User findByNameAndPassword(String name, String password) {
        try {
            return (User) sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("name", name))
                    .add(Restrictions.eq("password", password))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException("Can't find user by name='" + name + "' and password='" + password + "'.", e);
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<User> getUsers() {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .list();
        } catch (Exception e) {
            throw new DaoException("Can't get list of users.", e);
        }
    }


}
