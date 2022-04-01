package project.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender mailsender;

	public void sendemail(String toEmail, String body, String subject) {

		SimpleMailMessage emailmessage = new SimpleMailMessage();

		emailmessage.setFrom("birthdaypartyorganizer@outlook.com");
		emailmessage.setTo(toEmail);
		emailmessage.setText(body);
		emailmessage.setSubject(subject);
		mailsender.send(emailmessage);
		System.out.println("Email sent successfully");
	}
}
