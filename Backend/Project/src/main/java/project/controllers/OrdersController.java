package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.dao.OrdersDAO;
import project.entities.OrdersInfoTable;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersDAO daoOrders;
	
	
	@RequestMapping("/order/list")
	public ModelAndView getListOfOrders()
	{
		ModelAndView mv = new ModelAndView();

		List<OrdersInfoTable> list = daoOrders.findAll();

		mv.addObject("orders", list);  
		mv.setViewName("showorders"); 
		return mv;
	}
	
	
	
	
}