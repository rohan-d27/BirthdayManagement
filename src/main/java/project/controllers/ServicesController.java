package project.controllers;

import java.util.List;

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

import project.dao.ServicesDAO;
import project.entities.ServiceProviderInfoTable;
import project.entities.ServicesInfoTable;

@Controller
public class ServicesController {

	@Autowired
	ServicesDAO daoServices;

	@RequestMapping("/serviceslist")
	public ModelAndView getListOfServices() {
		ModelAndView mv = new ModelAndView();

		List<ServicesInfoTable> list = daoServices.findAll();

		mv.addObject("services", list);
		mv.setViewName("showservices");
		return mv;
	}

	@RequestMapping("/addService")
	public String addServices(HttpSession session) {
		if (session.getAttribute("Serviceprovider") != null) {

			return "ServiceInsert";
		} else
			return "index";

	}

	@PostMapping(path = "/ServiceInsert")
	public String insertService(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam String serviceName,
			@RequestParam String serviceDesc, @RequestParam double servicePrice, HttpSession session) {
		if (session.getAttribute("Serviceprovider") != null) {
			ServiceProviderInfoTable sp = (ServiceProviderInfoTable) session.getAttribute("Serviceprovider");
			ServicesInfoTable service = new ServicesInfoTable();
			service.setServiceName(serviceName);
			service.setServiceDesc(serviceDesc);
			service.setServicePrice(servicePrice);
			service.setServiceProviderInfoTable(sp);
			daoServices.insertServices(service);
			return "index";
		} else
			return "index";
	}

	@PostMapping(path = "/servicesupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateService(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody ServicesInfoTable sc,
			@RequestParam String serviceName, @RequestParam String serviceDesc, @RequestParam byte[] serviceImages,
			@RequestParam double servicePrice, @RequestParam ServiceProviderInfoTable serviceProvider,
			HttpSession session) throws Exception {
		if (session.getAttribute("Serviceprovider") != null) {
			int id = sc.getServiceId();
			daoServices.updateServices(id, serviceName, serviceDesc, 0, servicePrice, serviceImages);
			return "index";
		} else
			return "index";
	}

	@PostMapping(path = "/servicesdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteService(@RequestBody ServicesInfoTable sv, HttpSession session) throws Exception {
		if (session.getAttribute("Serviceprovider") != null) {
			daoServices.delete(sv);
			return "index";
		} else
			return "index";
	}

	@GetMapping(path = "/servicesserviceproviderslist", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ModelAndView getListForServiceProvider(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("Serviceprovider") != null) {
			ServiceProviderInfoTable sp = (ServiceProviderInfoTable) session.getAttribute("Serviceprovider");
			List<ServicesInfoTable> list = daoServices.findbyServiceproviderId(sp);
			mv.addObject("services", list);
			mv.setViewName("servicesbyserviceproviders");
			return mv;
		} else
			mv.setViewName("index");
		return mv;
	}
}