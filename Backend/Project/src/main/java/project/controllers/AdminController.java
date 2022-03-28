package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.dao.AdminDAO;
import project.entities.AdminInfoTable;

@Controller
public class AdminController {
	@Autowired
	AdminDAO daoAdmin;
	
	
	@GetMapping("/admin/list")
	public ModelAndView getListOfAdmins() {
	
		ModelAndView mv = new ModelAndView();

		List<AdminInfoTable> list = daoAdmin.findAll();

		mv.addObject("admins", list);  
		mv.setViewName("showadmins"); 
		return mv;
		
	}
	
	@GetMapping("/admin/login")
	public String login()
	{
		return "adminlogin";
	}
	@PostMapping("/admin/verify")
	public ModelAndView verify(@RequestParam String uname,@RequestParam String pass)
	{
		ModelAndView obj=new ModelAndView();
		System.out.println("daoAdmin.validateAdmin(uname, pass)"+daoAdmin.validateAdmin(uname, pass));
		obj.addObject("user",daoAdmin.validateAdmin(uname, pass));
		obj.setViewName("welcome");
		return obj;
	}
	
	
}