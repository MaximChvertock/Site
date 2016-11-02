package by.chvertock.web.site.model.forum;

public class NewMessageForm {

    private String title;
    private String text;
    
    private long topicId;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public long getTopicId() {
        return topicId;
    }
    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((text == null) ? 0 : text.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + (int) (topicId ^ (topicId >>> 32));
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
	NewMessageForm other = (NewMessageForm) obj;
	if (text == null) {
	    if (other.text != null) {
		return false;
	    }
	} else if (!text.equals(other.text)) {
	    return false;
	}
	if (title == null) {
	    if (other.title != null) {
		return false;
	    }
	} else if (!title.equals(other.title)) {
	    return false;
	}
	if (topicId != other.topicId) {
	    return false;
	}
	return true;
    }
    
    @Override
    public String toString() {
	return "NewMessageForm [title=" + title + ", text=" + text + ", topicId=" + topicId + "]";
    }
    
    
    
}
