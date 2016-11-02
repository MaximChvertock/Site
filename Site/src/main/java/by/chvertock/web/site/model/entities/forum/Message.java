package by.chvertock.web.site.model.entities.forum;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import by.chvertock.web.site.model.entities.User;


@Entity
@Table(name="message")
public class Message implements Serializable {
    
    private static final long serialVersionUID = -5861749816959717758L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="message_id", unique = true, nullable = false)
    private long id;
    
    @ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
    
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "caption", length = 255)
    private String caption;
    
    @Column(name = "text", nullable = false)
    private String text;
    
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getText() {
        return text;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + ((caption == null) ? 0 : caption.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((text == null) ? 0 : text.hashCode());
	result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
	Message other = (Message) obj;
	if (author == null) {
	    if (other.author != null) {
		return false;
	    }
	} else if (!author.equals(other.author)) {
	    return false;
	}
	if (caption == null) {
	    if (other.caption != null) {
		return false;
	    }
	} else if (!caption.equals(other.caption)) {
	    return false;
	}
	if (id != other.id) {
	    return false;
	}
	if (text == null) {
	    if (other.text != null) {
		return false;
	    }
	} else if (!text.equals(other.text)) {
	    return false;
	}
	if (timestamp == null) {
	    if (other.timestamp != null) {
		return false;
	    }
	} else if (!timestamp.equals(other.timestamp)) {
	    return false;
	}
	return true;
    }

    
    @Override
    public String toString() {
	return "Message [id=" + id + ", author=" + author + ", timestamp=" + timestamp + "("+timestamp.getTime()+")" + ", caption=" + caption
		+ ", text=" + text + "]";
    }

}
