package server;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class messageMail {

		

		public void main(String[] args, String email, String privateSender,String messageContent)  throws Exception{
			
			Properties props = new Properties();
		
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			Session session = Session.getInstance(props ,new javax.mail.Authenticator() {
			    protected 	PasswordAuthentication getPasswordAuthentication( ) {
			    	
			    
				    return new PasswordAuthentication("service.123ensa@gmail.com","serviceensa");
		                             	} }
			) ;
			
			MimeMessage message = new MimeMessage(session);
			
			try {
				message.setSubject("Nouveau message de "+privateSender);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			Address addressTo = null;
			try {
				addressTo = new InternetAddress(email);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				message.setRecipient(Message.RecipientType.TO, addressTo);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MimeMultipart multipart = new MimeMultipart();
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			try {
				
				messageBodyPart2.setContent("<p>" + messageContent+"</p>" ,  "text/html");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				
				multipart.addBodyPart(messageBodyPart2);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				message.setContent(multipart);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Transport.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

	}

