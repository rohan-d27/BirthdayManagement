package project.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import project.dao.CustomerDAO;
import project.entities.CustomerInfoTable;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO daoCustomer;

	@RequestMapping("/customer/list")
	public ModelAndView getListOfCustomers() {
		ModelAndView mv = new ModelAndView();

		List<CustomerInfoTable> list = daoCustomer.findAll();

		mv.addObject("customers", list);
		mv.setViewName("showcustomers");
		return mv;
	}

	/*
	 * @GetMapping("/customer/login") public String login() { return
	 * "customerlogin"; }
	 */
	@GetMapping("/customer/login")
	public ModelAndView customerLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (request.getSession().getAttribute("customer") == null) {
			mv.setViewName("customerlogin");
			return mv;
		} else {
			mv.setViewName("index");
			return mv;
		}
	}

	@PostMapping("/customer/verify")
	public ModelAndView verify(HttpServletRequest request, @RequestParam String customerUsername,
			@RequestParam String customerPassword) {
		ModelAndView obj = new ModelAndView();
		System.out.println("daoAdmin.validateCustomer(customerUsername, customerPassword)"
				+ daoCustomer.validateCustomer(customerUsername, customerPassword));
		obj.addObject("user", daoCustomer.validateCustomer(customerUsername, customerPassword));
		CustomerInfoTable customerdata = daoCustomer.findbyUsername(customerUsername);
		request.getSession().setAttribute("customer", customerdata);
		obj.setViewName("index");
		return obj;
	}

	@PostMapping(path = "/customer/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertCustomer(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam String customerFname, @RequestParam String customerLname, @RequestParam String customerMobno,
			@RequestParam String customerPassword, @RequestParam String customerUsername,
			@RequestParam String customerEmail, @RequestParam String customerAddress, @RequestParam String customerCity,
			@RequestParam int customerZipcode) throws Exception {
		CustomerInfoTable customer = new CustomerInfoTable();
		customer.setCustomerFname(customerFname);
		customer.setCustomerLname(customerLname);
		customer.setCustomerMobno(customerMobno);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerCity(customerCity);
		customer.setCustomerZipcode(customerZipcode);
		customer.setCustomerUsername(customerUsername);
		customer.setCustomerPassword(customerPassword);
		if (customer.getCustomerFname() != null)
			daoCustomer.insertCustomer(customer);
		return "index";
	}

	@PostMapping(path = "/customer/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateCustomer(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestBody CustomerInfoTable cs, @RequestParam String customerFname, @RequestParam String customerLname,
			@RequestParam String customerMobno, @RequestParam String customerPassword,
			@RequestParam String customerUsername, @RequestParam String customerEmail,
			@RequestParam String customerAddress, @RequestParam String customerCity, @RequestParam int customerZipcode)
			throws Exception {
		int id = cs.getCustomerId();
		daoCustomer.updateCustomer(id, customerFname, customerLname, customerMobno, customerEmail, customerAddress,
				customerCity, customerZipcode, customerUsername, customerPassword);
		return "index";
	}

	@PostMapping(path = "/customer/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteCustomer(@RequestBody CustomerInfoTable ck) throws Exception {

		daoCustomer.delete(ck);
		return "index";
	}
}