package com.actions.GemailSend;


import java.io.InputStream;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class sendMail {
	public static boolean sendingMail(String to, String from, String subject, String body) {
		boolean flage = false;

		// logic for sending email

		
		try {
			
			// The function sets up SMTP properties for connecting to Gmail's SMTP server
			// (smtp.gmail.com) on port 587
			Properties properties = new Properties();

			// Reading the config.properties file
			InputStream input = sendMail.class.getClassLoader().getResourceAsStream("config.properties");
			
			// Load properties file
			properties.load(input);

			// fetching username and password by passing key from properties file
			final String username = properties.getProperty("mail.username");
			final String password = properties.getProperty("mail.password");
            
			
			// creating session object to handle gmail sending process
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(username, password);
				}

			});

			
			// Creating and Sending the Email (A MimeMessage object is created to represent
			// the email message)

			// creating message object
			Message message = new MimeMessage(session);

			// sending from
			message.setFrom(new InternetAddress(from));
			// sending to
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// mail subject
			message.setSubject(subject);
			// mail text
			message.setText(body);

			// send message using Trasnport class static method Transport.send(message) and
			// pass our message
			Transport.send(message);

			// make our flage true
			flage = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flage;
	}

}
