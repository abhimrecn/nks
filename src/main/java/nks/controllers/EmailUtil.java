/**
 * 
 */
package nks.controllers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author a504073
 *
 */
public final class EmailUtil {
	
	public static void sendEmail(String response,String toEmail, String ownerMobileNo) {

		final String username = "namkeenkeshaukeens@gmail.com";
		final String password = "R@tlam2017";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ratlamkenamkeen@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toEmail));
			message.setSubject("NamkeenkeShaukeen Order Recieved.Thanks");
			message.setContent(response, "text/html; charset=utf-8");
			Transport.send(message);

			System.out.println("message sent successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void welcomeCustomer(String response,String toEmail) {

		final String username = "namkeenkeshaukeens@gmail.com";
		final String password = "R@tlam2017";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ratlamkenamkeen@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toEmail));
			message.setSubject("Welcome to NamkeenkeShaukeen");
			message.setContent(response, "text/html; charset=utf-8");
			Transport.send(message);

			System.out.println("message sent successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void recievedContact(String response,String toEmail, String ownerMobileNo) {

		final String username = "namkeenkeshaukeens@gmail.com";
		final String password = "R@tlam2017";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ratlamkenamkeen@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toEmail));
			message.setSubject("NamkeenkeShaukeen contact Recieved.Thanks");
			message.setContent(response, "text/html; charset=utf-8");
			Transport.send(message);

			System.out.println("message sent successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private void sendEmailViaAtos(String response,String toEmail, String ownerMobileNo) {
		// String to = "prashant.gour@atos.net";//change accordingly
		String from = "ratlamkenamkeen@atos.net";// change accordingly
		String host = "apac.it-solutions.myatos.net";// or IP address

		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject("Order Summary ");
			// String s2 =;
			//message.setText(response);
			message.setContent(response, "text/html; charset=utf-8");

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		sendEmail("hi","abhishek.agrawal@atos.net","8888888888sendEmail");	
	}
}
