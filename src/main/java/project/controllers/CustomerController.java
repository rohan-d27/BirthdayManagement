package project.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import project.EmailSender.EmailSender;
import project.dao.CustomerDAO;
import project.entities.CustomerInfoTable;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO daoCustomer;

	@RequestMapping("/customerlist")
	public ModelAndView getListOfCustomers() {
		ModelAndView mv = new ModelAndView();

		List<CustomerInfoTable> list = daoCustomer.findAll();

		mv.addObject("customers", list);
		mv.setViewName("showcustomers");
		return mv;
	}

	@GetMapping("/CustomerLogin")
	public ModelAndView customerLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (request.getSession().getAttribute("Customer") == null) {
			mv.setViewName("CustomerLogin");
			return mv;
		} else {
			request.getSession().invalidate();
			mv.setViewName("index");
			return mv;
		}
	}

	@RequestMapping("/CustomerProfile")
	public ModelAndView customerProfile(HttpSession session) {
		ModelAndView obj = new ModelAndView();
		if (session.getAttribute("Customer") != null) {
		obj.setViewName("CustomerProfile");
		return obj;}
		obj.setViewName("index");
		return obj;
	}

	@PostMapping("/CustomerForgotPassword")
	public String customerForgotpassword(@RequestParam String customerEmail) {
		EmailSender em = new EmailSender();
		CustomerInfoTable cs = daoCustomer.findbyEmail(customerEmail);
		em.userForgotPassword(cs.getCustomerEmail(), cs.getCustomerPassword());
		return "CustomerLogin";
	}

	@PostMapping("/CustomerVerify")
	public ModelAndView verify(HttpServletRequest request, @RequestParam String customerUsername,
			@RequestParam String customerPassword) {
		ModelAndView obj = new ModelAndView();
		obj.addObject("user", daoCustomer.validateCustomer(customerUsername, customerPassword));
		CustomerInfoTable customerdata = daoCustomer.findbyUsername(customerUsername);
		request.getSession().setAttribute("Customer", customerdata);

		obj.setViewName("index");
		return obj;
	}

	@RequestMapping("/CustomerForgot")
	public String customerForgot() {

		return "CustomerForgot";
	}

	@RequestMapping("/CustomerRegister")
	public String customerRegister() {

		return "CustomerRegistration";
	}

	@PostMapping(path = "/CustomerInsert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertCustomer(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam String customerFname, @RequestParam String customerLname, @RequestParam String customerMobno,
			@RequestParam String customerPassword, @RequestParam String customerUsername,
			@RequestParam String customerEmail) throws Exception {
		CustomerInfoTable customer = new CustomerInfoTable();
		customer.setCustomerFname(customerFname);
		customer.setCustomerLname(customerLname);
		customer.setCustomerMobno(customerMobno);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerUsername(customerUsername);
		customer.setCustomerPassword(customerPassword);
		if (customer.getCustomerFname() != null)
			daoCustomer.insertCustomer(customer);
		return "index";
	}

	@PostMapping(path = "/customerupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateCustomer(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestBody CustomerInfoTable cs, @RequestParam String customerFname, @RequestParam String customerLname,
			@RequestParam String customerMobno, @RequestParam String customerPassword,
			@RequestParam String customerUsername, @RequestParam String customerEmail,
			@RequestParam String customerAddress, @RequestParam String customerCity, @RequestParam int customerZipcode,HttpSession session)
			throws Exception {
		if (session.getAttribute("Customer") != null) {
		int id = cs.getCustomerId();
		daoCustomer.updateCustomer(id, customerFname, customerLname, customerMobno, customerEmail, customerAddress,
				customerCity, customerZipcode, customerUsername, customerPassword);
		return "index";}
		else
			return "index";
	}

	@PostMapping(path = "/customerdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteCustomer(@RequestBody CustomerInfoTable ck) throws Exception {

		daoCustomer.delete(ck);
		return "index";
	}
}