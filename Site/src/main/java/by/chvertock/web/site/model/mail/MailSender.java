package by.chvertock.web.site.model.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
    
    private String username;
    private String password;
    private Properties properties;
    
    public MailSender() {/*DEFAULT*/}

    public MailSender(String username, String password, Properties properties) {
        this.username = username;
        this.password = password;
        this.properties = properties;
    }
    
    private Session getSession(){
	Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
	return Session.getInstance( properties, authenticator);
    }
    
    public void send(MailMessage message){
	
	Session session = getSession();
	
	try{
	    MimeMessage msg = new MimeMessage(session);
	    
	    msg.setFrom(getUsername());
	    msg.addRecipients(Message.RecipientType.TO, message.getAddressList());
	    
	    msg.setSubject(message.getSubject(), "utf-8");
	    
	    BodyPart bodyPart = new MimeBodyPart();
	    bodyPart.setContent(message.getText(), "text/html; charset=utf-8");
	    
	    MimeMultipart multipart = new MimeMultipart();
	    multipart.addBodyPart(bodyPart);
	    
	    // TODO: make attachement
	    
	    msg.setContent(multipart);
	    
	    Transport.send(msg);
	    
	} catch (AddressException ex) {
	    throw new RuntimeException(ex);
	} catch (MessagingException ex) {
	    throw new RuntimeException(ex);
	}
    }
    
//    public void send(MailMessage message) {
//        Session session = getSession();
//        
//        try {
//            MimeMessage mimeMessage = new MimeMessage(session);
////            mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
//            mimeMessage.setRecipients(Message.RecipientType.TO, message.getAddressList());
//            mimeMessage.setSubject(message.getSubject());
//            mimeMessage.setText(message.getText());
//            mimeMessage.setFrom(new InternetAddress(username));
//            
//            System.setProperty("mail.mime.charset", "utf8");
//            
//            Transport.send(mimeMessage);
//
//        } catch (AddressException ex) {
//            throw new RuntimeException(ex);
//        } catch (MessagingException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

//    public void send(String to, String subject, String text) {
//	MailMessage msg = new MailMessage(to, subject, text);
//        
//        send(msg);
//    }

//    public void send(String email, File attached, String fname) {
//        Session session =
//                Session.getInstance(
//                        properties,
//                        new javax.mail.Authenticator() {
//                            @Override
//                            protected PasswordAuthentication getPasswordAuthentication() {
//                                return new PasswordAuthentication(login, password);
//                            }
//                        }
//                );
//
//        try {
//            // Create a default MimeMessage object.
//            Message message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(this.login)); // need for prevent blocking by gmail smpt server
//
//            // Set To: header field of the header.
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//
//            // Set Subject: header field
//            message.setSubject("Testing Subject");
//
//            // Create the message part
//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            // Now set the actual message
//            messageBodyPart.setText("This is message body");
//
//            // Create a multipar message
//            Multipart multipart = new MimeMultipart();
//
//            // Set text message part
//            multipart.addBodyPart(messageBodyPart);
//
//            // Part two is attachment
//            messageBodyPart = new MimeBodyPart();
//            String filename = attached.getAbsolutePath();
//            DataSource source = new FileDataSource(filename);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(fname);
//            multipart.addBodyPart(messageBodyPart);
//
//            // Send the complete message parts
//            message.setContent(multipart);
//
//            // Send message
//            Transport.send(message);
//
////            System.out.println("Sent message successfully....");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
	return "MailSender [username=" + username + ", password=" + password + ", properties=" + properties + "]";
    }

    
}