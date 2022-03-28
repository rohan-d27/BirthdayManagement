package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.dao.PackagesDAO;
import project.entities.PackagesInfoTable;

@Controller
public class PackagesController {
	
	@Autowired
	PackagesDAO daoPackages;
	
	
	@RequestMapping("/package/list")
	public ModelAndView getListOfPackages()
	{
		ModelAndView mv = new ModelAndView();

		List<PackagesInfoTable> list = daoPackages.findAll();

		mv.addObject("packages", list);  
		mv.setViewName("showpackages"); 
		return mv;
	}
	
	
	
	
}