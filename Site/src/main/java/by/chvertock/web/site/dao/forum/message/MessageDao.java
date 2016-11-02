package by.chvertock.web.site.dao.forum.message;

import java.io.Serializable;
import java.util.List;

import by.chvertock.web.site.model.entities.forum.Message;

public interface MessageDao {
    Serializable save(Message message);

    void update(Message message);

    void delete(Message message);

    List<Message> getMessages();

}
