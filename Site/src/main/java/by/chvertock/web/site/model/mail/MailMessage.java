package by.chvertock.web.site.model.mail;

import java.util.HashSet;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailMessage {
    
    private Set<String> recipients = new HashSet<String>();
    private String subject;
    private String text;
   
    public Set<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<String> recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public boolean addRecipient(String address){
	return recipients.add(address);
    }

    public boolean removeRecipient(String address){
	return recipients.remove(address);
    }
    
    public InternetAddress[] getAddressList() throws AddressException{
	StringBuilder builder = new StringBuilder();
	for(String address : recipients){
	    builder.append(",");
	    builder.append(address);
	}
	
	return InternetAddress.parse(builder.toString().substring(1));
    }
}
