package by.chvertock.web.site.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.user.UserDao;
import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.service.user.exceptions.UserDuplicateException;

import java.util.List;

/**
 * Created by mad on 6/29/16.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user) {
	try{
	    userDao.save(user);
	} catch(DaoException e){ // TODO: need more catches for various dao exceptions
	    throw new UserDuplicateException(user+" is already in DB");
	}
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Transactional
    public boolean isUserExist(User user) {
        return userDao.findByNameAndEmail(user.getName(), user.getEmail()) != null;
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
