
package project.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender mailsender;

	public void userForgotPassword(String email, String password) {

		SimpleMailMessage message = new SimpleMailMessage();

		String body = "This Is Your Password : " + password;
		String subject = "Forgot password";

		message.setFrom("birthdaypartyorganizer@outlook.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");
	}

	public void orderConfirm(String cmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("birthdaypartyorganizer@outlook.com");
		message.setTo(cmail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");

	}

	public void orderCancel(String cmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("birthdaypartyorganizer@outlook.com");
		message.setTo(cmail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("Mail sent");

	}
}
