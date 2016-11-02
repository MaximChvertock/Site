package by.chvertock.web.site.model.entities.forum;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import by.chvertock.web.site.model.entities.User;
import by.chvertock.web.site.model.utils.MessageComparator;

@Entity
@Table(name = "topic")
public class Topic implements Serializable {

    private static final long serialVersionUID = -5906565248989766084L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="topic_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
    
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    
    @Column(name = "active")
    private boolean active;
    
    @Column(name = "visible")
    private boolean visible;
    
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "topics_messages",
    	joinColumns = {@JoinColumn(name = "topic_id", nullable = false, updatable = false)},
    	inverseJoinColumns = {@JoinColumn(name = "message_id",nullable = false, updatable = false)})
    private Set<Message> messages = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Set<Message> getMessages() {
        return messages;
    }
    
    public Set<Message> getSortedMessages(){ // TODO: fix it dirty trick
	TreeSet<Message> result = new TreeSet<>(new MessageComparator());
	
	result.addAll(getMessages());
	
	return result;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((messages == null) ? 0 : messages.hashCode());
	result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + (visible ? 1231 : 1237);
	return result;
    }

    
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Topic other = (Topic) obj;
	if (active != other.active) {
	    return false;
	}
	if (author == null) {
	    if (other.author != null) {
		return false;
	    }
	} else if (!author.equals(other.author)) {
	    return false;
	}
	if (id != other.id) {
	    return false;
	}
	if (messages == null) {
	    if (other.messages != null) {
		return false;
	    }
	} else if (!messages.equals(other.messages)) {
	    return false;
	}
	if (timestamp == null) {
	    if (other.timestamp != null) {
		return false;
	    }
	} else if (!timestamp.equals(other.timestamp)) {
	    return false;
	}
	if (title == null) {
	    if (other.title != null) {
		return false;
	    }
	} else if (!title.equals(other.title)) {
	    return false;
	}
	if (visible != other.visible) {
	    return false;
	}
	return true;
    }

    
    @Override
    public String toString() {
	return "Topic [id=" + id + ", author=" + author + ", title=" + title + ", active=" + active + ", visible="
		+ visible + ", timestamp=" + timestamp + ", messages.count=" + messages.size() + "]";
    }
}
