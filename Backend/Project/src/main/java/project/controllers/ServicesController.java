package project.controllers;

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

import project.dao.ServicesDAO;
import project.entities.ServiceProviderInfoTable;
import project.entities.ServicesInfoTable;

@Controller
public class ServicesController {

	@Autowired
	ServicesDAO daoServices;

	@RequestMapping("/services/list")
	public ModelAndView getListOfServices() {
		ModelAndView mv = new ModelAndView();

		List<ServicesInfoTable> list = daoServices.findAll();

		mv.addObject("services", list);
		mv.setViewName("showservices");
		return mv;
	}

	@PostMapping(path = "/services/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertService(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam String serviceName,
			@RequestParam String serviceDesc, @RequestParam byte[] serviceImages, @RequestParam double servicePrice,
			@RequestParam ServiceProviderInfoTable serviceProvider) throws Exception {
		ServicesInfoTable service = new ServicesInfoTable();
		service.setServiceName(serviceName);
		service.setServiceDesc(serviceDesc);
		service.setServicePrice(servicePrice);
		service.setServiceImages(serviceImages);
		service.setServiceProviderInfoTable(serviceProvider);
		if (service.getServiceName() != null)
			daoServices.insertServices(service);
		return "index";
	}

	@PostMapping(path = "/services/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateService(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody ServicesInfoTable sc,
			@RequestParam String serviceName, @RequestParam String serviceDesc, @RequestParam byte[] serviceImages,
			@RequestParam double servicePrice, @RequestParam ServiceProviderInfoTable serviceProvider)
			throws Exception {
		int id = sc.getServiceId();
		daoServices.updateServices(id, serviceName, serviceDesc, 0, servicePrice, serviceImages);
		return "index";
	}

	@PostMapping(path = "/services/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteService(@RequestBody ServicesInfoTable sv) throws Exception {

		daoServices.delete(sv);
		return "index";
	}

	@GetMapping(path = "/services/serviceproviderslist", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ModelAndView getListForServiceProvider(@RequestParam ServiceProviderInfoTable s) {
		ModelAndView mv = new ModelAndView();
		List<ServicesInfoTable> list = daoServices.findbyServiceproviderId(s);
		mv.addObject("services", list);
		mv.setViewName("servicesbyserviceproviders");
		return mv;
	}
}