package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailException;

import project.EmailSender.EmailSender;

@SpringBootApplication
public class ProjectApplication {
	@Autowired
	private EmailSender sender;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ProjectApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MailException {

		sender.sendemail("to", "This is Email Body", "This is email subject");
	}
}
