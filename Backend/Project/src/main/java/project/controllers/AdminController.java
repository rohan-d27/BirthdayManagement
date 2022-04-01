package project.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.dao.AdminDAO;
import project.entities.AdminInfoTable;

@Controller
public class AdminController {
	@Autowired
	AdminDAO daoAdmin;

	/*
	 * @GetMapping("/admin/login") public String login() { return "adminlogin"; }
	 */
	@PostMapping("/admin/verify")
	public ModelAndView verify(HttpServletRequest request, @RequestParam String adminUsername,
			@RequestParam String adminPassword) {
		ModelAndView obj = new ModelAndView();
		System.out.println("daoAdmin.validateAdmin(adminUsername, adminPassword)"
				+ daoAdmin.validateAdmin(adminUsername, adminPassword));
		obj.addObject("user", daoAdmin.validateAdmin(adminUsername, adminPassword));
		AdminInfoTable admindata = daoAdmin.findbyUsername(adminUsername);
		request.getSession().setAttribute("admin", admindata);
		obj.setViewName("index");
		return obj;
	}

	@GetMapping("/admin/login")
	public ModelAndView adminLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (request.getSession().getAttribute("admin") == null) {
			mv.setViewName("adminlogin");
			return mv;
		} else {
			mv.setViewName("index");
			return mv;
		}
	}

	@GetMapping("/admin/logout")
	public ModelAndView adminLogout(HttpServletRequest request) {

		request.getSession().invalidate();
		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");

		return mv;
	}

	@GetMapping("/admin/list")
	public ModelAndView getListOfAdmins() {

		ModelAndView mv = new ModelAndView();

		List<AdminInfoTable> list = daoAdmin.findAll();

		mv.addObject("admins", list);
		mv.setViewName("showadmins");
		return mv;

	}

	@RequestMapping("/register")
	public String adminRegister() {

		return "AdminRegistration";
	}

	@PostMapping(path = "/admin/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertAdmin(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam String adminEmail,
			@RequestParam String adminUsername, @RequestParam String adminPassword, @RequestParam String adminFname,
			@RequestParam String adminLname, @RequestParam String adminMobno) throws Exception {
		AdminInfoTable admin = new AdminInfoTable();
		admin.setAdminFname(adminFname);
		admin.setAdminLname(adminLname);
		admin.setAdminMobno(adminMobno);
		admin.setAdminUsername(adminUsername);
		admin.setAdminPassword(adminPassword);
		admin.setAdminEmail(adminEmail);
		if (admin.getAdminFname() != null)
			daoAdmin.insertAdmin(admin);
		return "index";
	}

	@PostMapping(path = "/admin/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateAdmin(@RequestBody AdminInfoTable ad, @RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam String adminEmail, @RequestParam String adminUsername, @RequestParam String adminPassword,
			@RequestParam String adminFname, @RequestParam String adminLname, @RequestParam String adminMobno)
			throws Exception {
		int id = ad.getAdminId();
		daoAdmin.updateAdmin(id, adminFname, adminLname, adminMobno, adminEmail, adminUsername, adminPassword);
		return "index";
	}

	@PostMapping(path = "/admin/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteAdmin(@RequestBody AdminInfoTable ad) throws Exception {

		daoAdmin.delete(ad);
		return "index";
	}
}