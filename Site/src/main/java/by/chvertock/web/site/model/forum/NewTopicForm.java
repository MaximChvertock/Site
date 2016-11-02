package by.chvertock.web.site.model.forum;

public class NewTopicForm {

    private String title;
    private String text;
    
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
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((text == null) ? 0 : text.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
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
	NewTopicForm other = (NewTopicForm) obj;
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
	return true;
    }
   
    @Override
    public String toString() {
	return "NewTopicForm [title=" + title + ", text=" + text + "]";
    }
    
}
