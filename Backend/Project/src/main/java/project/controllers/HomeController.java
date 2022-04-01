package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@GetMapping("/admin/register")
	public String Register() {
		return "AdminRegistration";
	}
}
