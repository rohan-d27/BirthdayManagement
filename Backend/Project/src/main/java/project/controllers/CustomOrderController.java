package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.dao.CustomOrderDAO;
import project.entities.CustomOrderTable;

@Controller
public class CustomOrderController {
	
	@Autowired
	CustomOrderDAO daoCustomOrder;
	
	@RequestMapping("/customorder/list")
	public ModelAndView getListOfCustomOrder()
	{
		ModelAndView mv = new ModelAndView();

		List<CustomOrderTable> list = daoCustomOrder.findAll();

		mv.addObject("customorders", list);  
		mv.setViewName("showcustomorder"); 
		return mv;
	}
	
	
	
	
}