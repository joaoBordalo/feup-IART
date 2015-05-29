package utilities;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailTLS {
 
	public boolean sendEmail(String subjectText, String messageText,final String username,final String password, String recipientMail) {
 
		//final String username = "username";
		//final String password = "password";
 
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.fe.up.pt");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("IOT-NOTIFICATION"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipientMail));
			message.setSubject(subjectText);
			message.setText(messageText);
 
			Transport.send(message);
 
			
			//System.out.println("Done");
			return true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
