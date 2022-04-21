package project.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import project.EmailSender.EmailSender;
import project.dao.AdminDAO;
import project.dao.PackagesDAO;
import project.entities.AdminInfoTable;

@Controller
public class AdminController {
	@Autowired
	AdminDAO daoAdmin;
	@Autowired
	PackagesDAO daoPackage;

	@PostMapping("/AdminVerify")
	public ModelAndView verify(HttpServletRequest request, @RequestParam String adminUsername,
			@RequestParam String adminPassword) {
		ModelAndView obj = new ModelAndView();
		obj.addObject("user", daoAdmin.validateAdmin(adminUsername, adminPassword));
		AdminInfoTable admindata = daoAdmin.findbyUsername(adminUsername);
		request.getSession().setAttribute("Admin", admindata);
		obj.addObject("packages", daoPackage.findAll());
		obj.setViewName("AdminDashboardPackageDetails");

		return obj;
	}

	@GetMapping("/AdminLogin")
	public ModelAndView adminLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (request.getSession().getAttribute("admin") == null) {
			mv.setViewName("Adminlogin");
			return mv;
		} else {
			request.getSession().invalidate();
			mv.setViewName("index");
			return mv;
		}
	}

	@GetMapping("/adminlogout")
	public ModelAndView adminLogout(HttpServletRequest request) {

		request.getSession().invalidate();
		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");

		return mv;
	}

	@GetMapping("/adminlist")
	public ModelAndView getListOfAdmins(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("Admin") != null) {
		

		List<AdminInfoTable> list = daoAdmin.findAll();

		mv.addObject("admins", list);
		mv.setViewName("showadmins");
		return mv;}
		mv.setViewName("index");
		return mv;

	}

	@RequestMapping("/AdminDashboardPackageDetails")
	public ModelAndView adminDashboard(HttpSession session) {
		ModelAndView obj = new ModelAndView();
		if (session.getAttribute("Admin") != null) {
		obj.addObject("packages", daoPackage.findAll());
		obj.setViewName("AdminDashboardPackageDetails");
		return obj;}
		obj.setViewName("index");
		return obj;
	}

	@RequestMapping("/AdminForgot")
	public String adminForgot() {

		return "AdminForgot";
	}

	@PostMapping("/AdminForgotPassword")
	public String adminForgotpassword(@RequestParam String adminEmail) {
		EmailSender em = new EmailSender();
		AdminInfoTable adm = daoAdmin.findbyEmail(adminEmail);
		em.userForgotPassword(adminEmail, adm.getAdminPassword());
		return "Adminlogin";
	}

	@RequestMapping("/AdminRegister")
	public String adminRegister() {

		return "AdminRegistration";
	}

	@PostMapping(path = "/AdminInsert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
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

	@PostMapping(path = "/AdminUpdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateAdmin(@RequestBody AdminInfoTable ad, @RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam String adminEmail, @RequestParam String adminUsername, @RequestParam String adminPassword,
			@RequestParam String adminFname, @RequestParam String adminLname, @RequestParam String adminMobno,HttpSession session)
			throws Exception {
		if (session.getAttribute("Admin") != null) {
		int id = ad.getAdminId();
		daoAdmin.updateAdmin(id, adminFname, adminLname, adminMobno, adminEmail, adminUsername, adminPassword);
		return "index";}
		else
			return "index";
	}

	@PostMapping(path = "/admindelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteAdmin(@RequestBody AdminInfoTable ad,HttpSession session) throws Exception {
		if (session.getAttribute("Admin") != null) {
		
			daoAdmin.delete(ad);
		
		return "index";}
		else return "index";
		
	}
}
	