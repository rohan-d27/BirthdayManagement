package project.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import project.EmailSender.EmailSender;
import project.dao.CustomerDAO;
import project.dao.OrdersDAO;
import project.dao.PackagesDAO;
import project.entities.CustomerInfoTable;
import project.entities.OrdersInfoTable;
import project.entities.PackagesInfoTable;
import project.entities.ServiceProviderInfoTable;

@Controller
@SessionAttributes("order")
public class OrdersController {

	@Autowired
	OrdersDAO daoOrders;
	@Autowired
	PackagesDAO daoPackages;
	@Autowired
	CustomerDAO daoCustomer;

	@RequestMapping("/orderlist")
	public ModelAndView getListOfOrders() {
		ModelAndView mv = new ModelAndView();
		List<OrdersInfoTable> list = daoOrders.findAll();
		mv.addObject("orders", list);
		mv.setViewName("ShowAllOrders");
		return mv;
	}

	@PostMapping("/ViewOrderDetails")
	public String viewOrder(HttpServletRequest request, @RequestParam int packageId, HttpSession session) {
		if (session.getAttribute("Customer") != null) {
			PackagesInfoTable pk = daoPackages.findById(packageId).get();
			session.setAttribute("package2", pk);
			return "ViewOrderDetails";
		} else {
			return "CustomerLogin";
		}
	}

	@RequestMapping("/ordercancel")
	public String cancelOrders(@RequestParam int id) {
		OrdersInfoTable obj = daoOrders.findById(id).get();
		obj.setOrderStatus("Cancelled");
		CustomerInfoTable c = obj.getCustomerInfoTable();
		EmailSender em = new EmailSender();
		em.orderCancel(c.getCustomerEmail(), "Order Cancelled", "Order Cancelled");
		return "index";
	}

	@PostMapping(path = "/confirmorder", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String confirmOrder(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam String eventDate,
			@RequestParam String eventTime, @RequestParam String eventVenue, @RequestParam int numberOfGuests,
			HttpSession session, HttpServletRequest request) throws Exception {
		CustomerInfoTable cs = (CustomerInfoTable) session.getAttribute("Customer");
		OrdersInfoTable order = new OrdersInfoTable();
		PackagesInfoTable pk = (PackagesInfoTable) session.getAttribute("package2");
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date utildate = format.parse(eventDate);
		java.sql.Date date3 = new java.sql.Date(utildate.getTime());

		order.setCustomerInfoTable(cs);
		order.setPackagesInfoTable(pk);
		order.setOrderDate(date.getTime());
		order.setEventDate(date3);
		order.setEventTime(eventTime);
		order.setEventVenue(eventVenue);
		order.setNumberOfGuests(numberOfGuests);
		order.setOrderAmount(pk.getPackagePrice());
		order.setOrderStatus("Confirmed");
		daoOrders.insertOrder(order);
		//CustomerInfoTable customer = (CustomerInfoTable) session.getAttribute("Customer");
		/*
		 * String cmail = customer.getCustomerEmail(); EmailSender email = new
		 * EmailSender(); email.orderConfirm(cmail, "Order Confirmed",
		 * "Order Confirmed");
		 */
		return "index";
	}

	@PostMapping(path = "/orderupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateOrder(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody OrdersInfoTable od,
			@RequestParam Date orderDate, @RequestParam Date eventDate, @RequestParam String eventTime,
			@RequestParam String orderStatus, @RequestParam String eventVenue, @RequestParam int numberOfGuests,
			@RequestParam double orderAmount) throws Exception {
		int id = od.getOrderId();
		daoOrders.updateOrder(id, orderDate, eventDate, eventTime, eventVenue, numberOfGuests, orderAmount,
				orderStatus);
		return "index";
	}

	@PostMapping(path = "/orderdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteOrder(@RequestBody OrdersInfoTable od) throws Exception {

		daoOrders.delete(od);
		return "index";
	}

	@GetMapping(path = "/ordercustomerorderlist")
	public ModelAndView getListOfCustomerOrders(HttpSession session) {
		
		CustomerInfoTable cs=(CustomerInfoTable)session.getAttribute("Customer");
		ModelAndView mv = new ModelAndView();
		List<OrdersInfoTable> list = daoOrders.findbyCustomerId(cs);
		mv.addObject("orders", list);
		mv.setViewName("ShowCustomerOrders");
		return mv;
	}
	@GetMapping(path = "/ordersporderlist")
	public ModelAndView getListOfSpOrders(HttpSession session) {
		ServiceProviderInfoTable service=(ServiceProviderInfoTable)session.getAttribute("Serviceprovider");
		ModelAndView mv = new ModelAndView();
		List<OrdersInfoTable> list = daoOrders.findByServiceProvidersId(service.getServiceProviderId());
		mv.addObject("orders", list);
		mv.setViewName("ShowSPOrders");
		return mv;
	}
}