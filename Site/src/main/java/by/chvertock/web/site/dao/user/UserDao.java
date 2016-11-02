package by.chvertock.web.site.dao.user;

import java.util.List;

import by.chvertock.web.site.model.entities.User;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(User user);

    User findByName(String name);
    User findByEmail(String email);
    User findByNameAndEmail(String name, String email);

    User findByNameAndPassword(String name, String password);

    List<User> getUsers();
}
