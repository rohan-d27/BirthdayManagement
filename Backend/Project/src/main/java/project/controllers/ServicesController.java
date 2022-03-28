package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.dao.ServicesDAO;
import project.entities.ServicesInfoTable;

@Controller
public class ServicesController {
	
	@Autowired
	ServicesDAO daoServices;
	
	@RequestMapping("/services/list")
	public ModelAndView getListOfServices()
	{
		ModelAndView mv = new ModelAndView();

		List<ServicesInfoTable> list = daoServices.findAll();

		mv.addObject("services", list);  
		mv.setViewName("showservices"); 
		return mv;
	}
	
	
	
	
}