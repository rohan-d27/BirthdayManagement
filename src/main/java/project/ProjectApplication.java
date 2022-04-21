package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {
	// @Autowired
	// private EmailSender sender;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ProjectApplication.class, args);
	}
	/*
	 * @EventListener(ApplicationReadyEvent.class) public void triggerMail() throws
	 * MailException {
	 * 
	 * sender.sendemail("dharurkarr@gmail.com",
	 * "This is Email Body","This is email subject"); }
	 */
}
