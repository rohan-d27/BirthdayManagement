package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.dao.CustomerDAO;
import project.entities.CustomerInfoTable;


@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO daoCustomer;
	
	
	@RequestMapping("/customer/list")
	public ModelAndView getListOfCustomers()
	{
		ModelAndView mv = new ModelAndView();

		List<CustomerInfoTable> list = daoCustomer.findAll();

		mv.addObject("customers", list);  
		mv.setViewName("showcustomers"); 
		return mv;
	}
	@GetMapping("/customer/login")
	public String login()
	{
		return "customerlogin";
	}
	@PostMapping("/customer/verify")
	public ModelAndView verify(@RequestParam String uname,@RequestParam String pass)
	{
		ModelAndView obj=new ModelAndView();
		System.out.println("daoAdmin.validateCustomer(uname, pass)"+daoCustomer.validateCustomer(uname, pass));
		obj.addObject("user",daoCustomer.validateCustomer(uname, pass));
		obj.setViewName("welcome");
		return obj;
	}
}