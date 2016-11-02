package by.chvertock.web.site.dao.role.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.role.RoleDao;
import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.RoleType;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Role role) {
        try {
            sessionFactory.getCurrentSession().save(role);
        } catch (Exception e) {
            throw new DaoException("Can't save role '" + role + "' to database.", e);
        }
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(Role role) {

    }

    @Override
    public Role findById(int id){
	try{
	    return (Role) sessionFactory
		    .getCurrentSession()
		    .get(Role.class, id);
	} catch (Exception e) {
            throw new DaoException("Can't find role by id=" + id, e);
        }
    }

    @Override
    public Role findByType(RoleType type) {
        try {
            return (Role) sessionFactory
                    .getCurrentSession()
                    .createCriteria(Role.class)
                    .add(Restrictions.eq("type", type))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException("Can't find role by type=" + type, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoles() {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createCriteria(Role.class)
                    .list();
        } catch (Exception e) {
            throw new DaoException("Can't get list of roles", e);
        }
    }
}
