package by.chvertock.web.site.dao.forum.topic;


import java.io.Serializable;
import java.util.List;

import by.chvertock.web.site.model.entities.forum.Topic;

public interface TopicDao {
    Serializable save(Topic topic);

    void update(Topic topic);

    void delete(Topic topic);
    
    Topic getTopicById(long id);

    List<Topic> getTopics();

}
