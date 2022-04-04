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


import project.dao.ServiceProviderDAO;
import project.dao.ServicesDAO;
import project.entities.ServiceProviderInfoTable;
import project.entities.ServicesInfoTable;

@Controller
public class ServiceProviderController {

	@Autowired
	ServiceProviderDAO daoServiceProvider;

	@Autowired
	ServicesDAO daoServices;

	@RequestMapping("/serviceLogin")
	public String serviceLogin() {
		
		return "ServiceProviderLogin";
	}
	//updated
	@RequestMapping("/ServiceProviderDashboard")
	public ModelAndView serviceDash(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		ServiceProviderInfoTable serviceprovider= (ServiceProviderInfoTable)session.getAttribute("Serviceprovider");
		List<ServicesInfoTable> services=daoServices.findbyServiceproviderId(serviceprovider);
		if(services!=null)
		mv.addObject("Services", services);
		mv.setViewName("ServiceProviderDashboard");
		 
		return mv;
	}
	
	
	@RequestMapping("/serviceproviderslist")
	public ModelAndView getListOfServiceProviders() {
		ModelAndView mv = new ModelAndView();

		List<ServiceProviderInfoTable> list = daoServiceProvider.findAll();

		mv.addObject("serviceproviders", list);
		mv.setViewName("showserviceproviders");
		return mv;
	}



	@GetMapping("/ServiceProviderLogin")
	public ModelAndView serviceProviderLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (request.getSession().getAttribute("serviceprovider") == null) {
			mv.setViewName("ServiceProviderLogin");
			return mv;
		} else {
			request.getSession().invalidate();
			mv.setViewName("index");
			return mv;
		}
	}

	

	@PostMapping("/ServiceProviderVerify")
	public ModelAndView verify(HttpServletRequest request, @RequestParam String serviceProviderUsername,@RequestParam String serviceProviderPassword) {
		ModelAndView obj = new ModelAndView();
		obj.addObject("user",daoServiceProvider.validateServiceprovider(serviceProviderUsername, serviceProviderPassword));
		ServiceProviderInfoTable serviceproviderdata = daoServiceProvider.findbyUsername(serviceProviderUsername);
		request.getSession().setAttribute("Serviceprovider", serviceproviderdata);
		obj.addObject("services", daoServices.findAll());
		obj.setViewName("index");
		return obj;
	}

	@RequestMapping("/ServiceProviderRegister")
	public String serviceproviderRegister() {

		return "ServiceProviderRegister";
	}

	@RequestMapping("/ServiceProviderForgot")
	public String serviceproviderForgot() {

		return "ServiceProviderForgot";
	}

	@PostMapping(path = "/ServiceProviderInsert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertServiceProvider(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam String serviceProviderFname, @RequestParam String serviceProviderLname,
			@RequestParam String serviceProviderMobno, @RequestParam String serviceProviderPassword,
			@RequestParam String serviceProviderUsername, @RequestParam String serviceProviderEmail) throws Exception {
		ServiceProviderInfoTable serviceprovider = new ServiceProviderInfoTable();
		serviceprovider.setServiceProviderFname(serviceProviderFname);
		serviceprovider.setServiceProviderLname(serviceProviderLname);
		serviceprovider.setServiceProviderEmail(serviceProviderEmail);
		serviceprovider.setServiceProviderMobno(serviceProviderMobno);
		serviceprovider.setServiceProviderUsername(serviceProviderUsername);
		serviceprovider.setServiceProviderPassword(serviceProviderPassword);
		if (serviceprovider.getServiceProviderFname() != null)
			daoServiceProvider.insertServiceProvider(serviceprovider);
		return "index";
	}

	@PostMapping(path = "/serviceproviderupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
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

	@PostMapping(path = "/serviceproviderdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteServiceProvider(@RequestBody ServiceProviderInfoTable sp) throws Exception {

		daoServiceProvider.delete(sp);
		return "index";
	}
}