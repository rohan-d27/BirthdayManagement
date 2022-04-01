package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.dao.CustomOrderDAO;
import project.entities.CustomOrderTable;
import project.entities.CustomOrderTablePK;
import project.entities.OrdersInfoTable;
import project.entities.ServicesInfoTable;

@Controller
public class CustomOrderController {

	@Autowired
	CustomOrderDAO daoCustomOrder;

	@RequestMapping("/customorder/list")
	public ModelAndView getListOfCustomOrder() {
		ModelAndView mv = new ModelAndView();

		List<CustomOrderTable> list = daoCustomOrder.findAll();

		mv.addObject("customorders", list);
		mv.setViewName("showcustomorder");
		return mv;
	}

	@PostMapping(path = "/customorder/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertCustomOrder(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam OrdersInfoTable order, @RequestParam ServicesInfoTable service) throws Exception {
		CustomOrderTable customorder = new CustomOrderTable();
		customorder.setOrdersInfoTable(order);
		customorder.setServicesInfoTable(service);

		if (customorder.getOrdersInfoTable() != null)
			daoCustomOrder.insertCustomOrder(customorder);
		return "index";
	}

	@PostMapping(path = "/customorder/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateCustomOrder(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestBody CustomOrderTable cb, @RequestParam ServicesInfoTable service) throws Exception {
		CustomOrderTablePK id = cb.getId();
		daoCustomOrder.updateCustomOrder(id, service);
		return "index";
	}

	@PostMapping(path = "/customorder/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteCustomOrder(@RequestBody CustomOrderTable co) throws Exception {

		daoCustomOrder.delete(co);
		return "index";
	}
}