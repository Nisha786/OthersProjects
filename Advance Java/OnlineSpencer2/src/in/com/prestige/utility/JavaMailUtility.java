package in.com.prestige.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtility {
   public JavaMailUtility(){}
   
 
   public static void sendEmail(String username,String password){
	 //code for send email for service provider
		final String username_mail = "c.deependra471@gmail.com";
		final String password_mail = "9685566182";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session_mail = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username_mail, password_mail);
			}
		  });
		try {
			Message message = new MimeMessage(session_mail);
			message.setFrom(new InternetAddress("c.deependra471@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("c.deependra471@gmail.com"));
			message.setSubject("User Registration");
			message.setText("New User is Registeterd , UserName : "+username + "   .....And Password : "+password);
			Transport.send(message);
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
   }
   
   //send Order Email
   public static void sendOrderEmail(String pname,String email,int qua,double price){
		 //code for send email for service provider
			final String username_mail = "c.deependra471@gmail.com";
			final String password_mail = "9685566182";
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session_mail = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username_mail, password_mail);
				}
			  });
			try {
				Message message = new MimeMessage(session_mail);
				message.setFrom(new InternetAddress("c.deependra471@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("c.deependra471@gmail.com"));
				message.setSubject("Booking Confirmation");
				message.setText("Booking Confirm, by : "+email + "   .....And Booked: "+pname +"....Quantity :"+qua+"......and Price :"+price);
				Transport.send(message);
				
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	   }
   
}
