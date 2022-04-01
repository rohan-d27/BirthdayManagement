package project.controllers;

import java.sql.Time;
import java.util.Date;
import java.util.List;

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

import project.dao.OrdersDAO;
import project.entities.CustomerInfoTable;
import project.entities.OrdersInfoTable;
import project.entities.PackagesInfoTable;

@Controller
public class OrdersController {

	@Autowired
	OrdersDAO daoOrders;

	@RequestMapping("/order/list")
	public ModelAndView getListOfOrders() {
		ModelAndView mv = new ModelAndView();

		List<OrdersInfoTable> list = daoOrders.findAll();

		mv.addObject("orders", list);
		mv.setViewName("showorders");
		return mv;
	}

	@PostMapping(path = "/order/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertOrder(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam CustomerInfoTable customer, @RequestParam PackagesInfoTable pk, @RequestParam Date orderDate,
			@RequestParam Date eventDate, @RequestParam Time eventTime, @RequestParam String orderStatus,
			@RequestParam String eventVenue, @RequestParam int numberOfGuests, @RequestParam double orderAmount)
			throws Exception {
		OrdersInfoTable order = new OrdersInfoTable();
		order.setCustomerInfoTable(customer);
		order.setPackagesInfoTable(pk);
		order.setOrderDate(orderDate);
		order.setEventDate(eventDate);
		order.setEventTime(eventTime);
		order.setEventVenue(eventVenue);
		order.setNumberOfGuests(numberOfGuests);
		order.setOrderAmount(orderAmount);
		order.setOrderStatus(orderStatus);

		if (order.getCustomerInfoTable() != null)
			daoOrders.insertOrder(order);
		return "index";
	}

	@PostMapping(path = "/order/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateOrder(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody OrdersInfoTable od,
			@RequestParam PackagesInfoTable pk, @RequestParam Date orderDate, @RequestParam Date eventDate,
			@RequestParam Time eventTime, @RequestParam String orderStatus, @RequestParam String eventVenue,
			@RequestParam int numberOfGuests, @RequestParam double orderAmount) throws Exception {
		int id = od.getOrderId();
		daoOrders.updateOrder(id, pk, orderDate, eventDate, eventTime, eventVenue, numberOfGuests, orderAmount,
				orderStatus);
		return "index";
	}

	@PostMapping(path = "/order/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteOrder(@RequestBody OrdersInfoTable od) throws Exception {

		daoOrders.delete(od);
		return "index";
	}

	@GetMapping(path = "/order/customerorderlist", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ModelAndView getListOfCustomerOrders(@RequestParam CustomerInfoTable cs) {
		ModelAndView mv = new ModelAndView();
		List<OrdersInfoTable> list = daoOrders.findbyCustomerId(cs);
		mv.addObject("orders", list);
		mv.setViewName("showcustomerorders");
		return mv;
	}
}