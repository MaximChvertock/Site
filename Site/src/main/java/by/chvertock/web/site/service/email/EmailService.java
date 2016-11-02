package by.chvertock.web.site.service.email;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import by.chvertock.web.site.model.contact.ContactMessageForm;
import by.chvertock.web.site.model.mail.MailMessage;
import by.chvertock.web.site.model.mail.MailSender;
import by.chvertock.web.site.service.email.exceptions.EmptyMailMessageException;

@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

//    public static class Message {
//        private String email;
//        private String subject;
//        private String text;
//
//        public Message() {
//        }
//
//        public Message(String email, String text) {
//            this.email = email;
//            this.text = text;
//        }
//
//        public Message(String email, String subject, String text) {
//            this.email = email;
//            this.subject = subject;
//            this.text = text;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getSubject() {
//            return subject;
//        }
//
//        public void setSubject(String subject) {
//            this.subject = subject;
//        }
//
//        public String getText() {
//            return text;
//        }
//
//        public void setText(String text) {
//            this.text = text;
//        }
//    }

    public void sendMessage(MailMessage message) {
        if (message == null) {
            throw new EmptyMailMessageException("Argument 'message' is null.");
        }
	mailSender.send(message);
	System.out.println("Send message: "+message);
    }
    
    
    private static final String CONTACT_MESSAGE_TITLE_TEMPLATE = "Contact message from ";
    @Value("${contact.email}")
    private String contactEmail; // TODO: use database for storing contact email
    public void sendContactMessage(ContactMessageForm form){
	
	System.out.println(mailSender);
	
	MailMessage message = new MailMessage();
	
	String name = "Anonymous";
	if( StringUtils.isNotBlank(form.getName())){
            name = form.getName();
        }
	
	message.addRecipient(contactEmail);
	message.setText(form.getText());
	message.setSubject(CONTACT_MESSAGE_TITLE_TEMPLATE + name);
        
        sendMessage(message);        
    }
}
