package by.chvertock.web.site.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.chvertock.web.site.dao.exceptions.DaoException;
import by.chvertock.web.site.dao.role.RoleDao;
import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.RoleType;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    @Transactional
    public void save(final Role role) {
	roleDao.save(role);
    }
    
    @Transactional
    public Role saveOrGet(final Role role) {
	Role roleFromDb = findByType(role.getType());
	
	if(roleFromDb == null){
	    roleDao.save(role);
	    return role;
	}
	
	return roleFromDb;
    }

    @Transactional
    public void update(final Role role) {
        roleDao.update(role);
    }

    @Transactional
    public void delete(final Role role) {
        roleDao.delete(role);
    }
    
    @Transactional
    public Role findById(int id){
	try{
	    return roleDao.findById(id);
	} catch(DaoException e){
	    return null;
	}
    }
    
    @Transactional
    public Role findByType(RoleType type) {
	try{
	    return roleDao.findByType(type); 
	} catch(DaoException e){
	    return null;
	}
    }

    @Transactional
    public boolean IsRoleExist(final Role role) {
        return findByType(role.getType()) != null;
    }

    @Transactional
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}