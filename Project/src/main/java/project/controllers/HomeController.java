package project.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/logout")
	public ModelAndView Logout(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;

	}

	@GetMapping("/register")
	public String Register() {
		return "AdminRegistration";
	}

	@GetMapping("/services")
	public String Service() {
		return "services";
	}

	@GetMapping("/Contact")
	public String Contact() {
		return "Contact";
	}

	@GetMapping("/about")
	public String About() {
		return "about";
	}
	@GetMapping("/cakes")
	public String Cakes() {
		return "Cakes";
	}
	@GetMapping("/musicsystem")
	public String Musicsystem() {
		return "musicsystem";
	}
	@GetMapping("/artist")
	public String Artist() {
		return "artist";
	}
	@GetMapping("/catering")
	public String Catering() {
		return "catering";
	}

	@GetMapping("/decoration")
	public String Decoration() {
		return "decoration";
	}
	
	@GetMapping("/photovideo")
	public String Photovideo() {
		return "photovideo";
	}
}
