
package project.EmailSender;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost("smtp.gmail.com");
		mailsender.setPort(587);
		mailsender.setUsername("projectmail79@gmail.com");
		mailsender.setPassword("dumrfashxigypnon");

		Properties props = mailsender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailsender;
	}

	public void userForgotPassword(String email, String password) {
		JavaMailSenderImpl mailsender = (JavaMailSenderImpl) getJavaMailSender();

		SimpleMailMessage message = new SimpleMailMessage();

		String body = "This Is Your Password : " + password;
		String subject = "Forgot password";

		message.setFrom("projectmail79@gmail.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");
	}

	public void orderConfirm(String cmail, String subject, String body) {

		JavaMailSenderImpl mailsender = (JavaMailSenderImpl) getJavaMailSender();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("projectmail79@gmail.com");
		message.setTo(cmail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");

	}

	public void orderCancel(String cmail, String subject, String body) {
		JavaMailSenderImpl mailsender = (JavaMailSenderImpl) getJavaMailSender();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("projectmail79@gmail.com");
		message.setTo(cmail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");

	}

	public void sendemail(String cmail, String subject, String body) {
		JavaMailSenderImpl mailsender = (JavaMailSenderImpl) getJavaMailSender();

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(cmail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");
	}
}
