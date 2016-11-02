package by.chvertock.web.site.dao.role;

import java.util.List;

import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.RoleType;

public interface RoleDao {
    void save(Role role);

    void update(Role role);

    void delete(Role role);

    Role findById(int id);
    
    Role findByType(RoleType roleType);

    List<Role> getRoles();
}
