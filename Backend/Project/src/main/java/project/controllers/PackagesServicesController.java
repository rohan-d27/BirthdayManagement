package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.dao.PackagesServicesDAO;
import project.entities.PackagesServicesTable;

@Controller
public class PackagesServicesController {
	
	@Autowired
	PackagesServicesDAO daoPackagesServices;
	
	@RequestMapping("/packgesservices/list")
	public ModelAndView getListOfPackagesServices()
	{
		ModelAndView mv = new ModelAndView();

		List<PackagesServicesTable> list = daoPackagesServices.findAll();

		mv.addObject("packagesservices", list);  
		mv.setViewName("showpackagesservices"); 
		return mv;
	}
	
	
	
	
}