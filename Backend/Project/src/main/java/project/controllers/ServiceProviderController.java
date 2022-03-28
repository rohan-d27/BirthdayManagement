package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.dao.ServiceProviderDAO;
import project.entities.ServiceProviderInfoTable;

@Controller
public class ServiceProviderController {
	
	@Autowired
	ServiceProviderDAO daoServiceProvider;
	
	@RequestMapping("/serviceproviders/list")
	public ModelAndView getListOfServiceProviders()
	{
		ModelAndView mv = new ModelAndView();

		List<ServiceProviderInfoTable> list = daoServiceProvider.findAll();

		mv.addObject("serviceproviders", list);  
		mv.setViewName("showserviceproviders"); 
		return mv;
	}
	@GetMapping("/serviceprovider/login")
	public String login()
	{
		return "serviceproviderlogin";
	}
	@PostMapping("/serviceprovider/verify")
	public ModelAndView verify(@RequestParam String uname,@RequestParam String pass)
	{
		ModelAndView obj=new ModelAndView();
		System.out.println("daoServiceProvider.validateServiceProvider(uname, pass)"+daoServiceProvider.validateServiceprovider(uname, pass));
		obj.addObject("user",daoServiceProvider.validateServiceprovider(uname, pass));
		obj.setViewName("welcome");
		return obj;
	}
	
	
	
}