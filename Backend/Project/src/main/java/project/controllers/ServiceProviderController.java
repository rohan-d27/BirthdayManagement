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

import project.dao.ServiceProviderDAO;
import project.entities.ServiceProviderInfoTable;

@Controller
public class ServiceProviderController {

	@Autowired
	ServiceProviderDAO daoServiceProvider;

	@RequestMapping("/serviceproviders/list")
	public ModelAndView getListOfServiceProviders() {
		ModelAndView mv = new ModelAndView();

		List<ServiceProviderInfoTable> list = daoServiceProvider.findAll();

		mv.addObject("serviceproviders", list);
		mv.setViewName("showserviceproviders");
		return mv;
	}

	/*
	 * @GetMapping("/serviceprovider/login") public String login() { return
	 * "serviceproviderlogin"; }
	 */

	@GetMapping("/serviceprovider/login")
	public ModelAndView serviceProviderLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (request.getSession().getAttribute("serviceprovider") == null) {
			mv.setViewName("serviceproviderlogin");
			return mv;
		} else {
			mv.setViewName("index");
			return mv;
		}
	}

	@PostMapping("/serviceprovider/verify")
	public ModelAndView verify(HttpServletRequest request, @RequestParam String serviceProviderUsername,
			@RequestParam String serviceProviderPassword) {
		ModelAndView obj = new ModelAndView();
		System.out
				.println("daoServiceProvider.validateServiceProvider(serviceProviderUsername, serviceProviderPassword)"
						+ daoServiceProvider.validateServiceprovider(serviceProviderUsername, serviceProviderPassword));
		obj.addObject("user",
				daoServiceProvider.validateServiceprovider(serviceProviderUsername, serviceProviderPassword));
		ServiceProviderInfoTable serviceproviderdata = daoServiceProvider.findbyUsername(serviceProviderUsername);
		request.getSession().setAttribute("serviceprovider", serviceproviderdata);
		obj.setViewName("index");
		return obj;
	}

	@PostMapping(path = "/serviceprovider/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertServiceProvider(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam String serviceProviderFname, @RequestParam String serviceProviderLname,
			@RequestParam String serviceProviderMobno, @RequestParam String serviceProviderPassword,
			@RequestParam String serviceProviderUsername, @RequestParam String serviceProviderEmail,
			@RequestParam String serviceProviderAddress, @RequestParam String serviceProviderCity,
			@RequestParam int serviceProviderZipcode) throws Exception {
		ServiceProviderInfoTable serviceprovider = new ServiceProviderInfoTable();
		serviceprovider.setServiceProviderFname(serviceProviderFname);
		serviceprovider.setServiceProviderLname(serviceProviderLname);
		serviceprovider.setServiceProviderEmail(serviceProviderEmail);
		serviceprovider.setServiceProviderMobno(serviceProviderMobno);
		serviceprovider.setServiceProviderAddress(serviceProviderAddress);
		serviceprovider.setServiceProviderCity(serviceProviderCity);
		serviceprovider.setServiceProviderZipcode(serviceProviderZipcode);
		serviceprovider.setServiceProviderUsername(serviceProviderUsername);
		serviceprovider.setServiceProviderPassword(serviceProviderPassword);
		if (serviceprovider.getServiceProviderFname() != null)
			daoServiceProvider.insertServiceProvider(serviceprovider);
		return "index";
	}

	@PostMapping(path = "/serviceprovider/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateServiceProvider(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestBody ServiceProviderInfoTable sp, @RequestParam String serviceProviderFname,
			@RequestParam String serviceProviderLname, @RequestParam String serviceProviderMobno,
			@RequestParam String serviceProviderPassword, @RequestParam String serviceProviderUsername,
			@RequestParam String serviceProviderEmail, @RequestParam String serviceProviderAddress,
			@RequestParam String serviceProviderCity, @RequestParam int serviceProviderZipcode) throws Exception {
		int id = sp.getServiceProviderId();
		daoServiceProvider.updateServiceProvider(id, serviceProviderFname, serviceProviderLname, serviceProviderMobno,
				serviceProviderEmail, serviceProviderAddress, serviceProviderCity, serviceProviderZipcode,
				serviceProviderUsername, serviceProviderPassword);
		return "index";
	}

	@PostMapping(path = "/serviceprovider/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteServiceProvider(@RequestBody ServiceProviderInfoTable sp) throws Exception {

		daoServiceProvider.delete(sp);
		return "index";
	}
}