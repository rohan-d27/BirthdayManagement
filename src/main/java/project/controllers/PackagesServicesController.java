package project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.dao.PackagesServicesDAO;
import project.dao.ServicesDAO;
import project.entities.PackagesInfoTable;
import project.entities.PackagesServicesTable;
import project.entities.PackagesServicesTablePK;
import project.entities.ServicesInfoTable;

@Controller
public class PackagesServicesController {

	@Autowired
	PackagesServicesDAO daoPackagesServices;
	@Autowired
	ServicesDAO daoServices;
	@RequestMapping("/PackageServicesList")
	public ModelAndView packageserviceedit(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		PackagesInfoTable pk=(PackagesInfoTable)session.getAttribute("package");
		List<ServicesInfoTable> list = daoServices.findBypackageId(pk.getPackageId());
		mv.addObject("Services", list);
		return mv;

	}

	@RequestMapping("/PackageServiceDetailsEdit")
	public ModelAndView packageserviceedit2(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		PackagesInfoTable pk=(PackagesInfoTable)session.getAttribute("package");
		List<ServicesInfoTable> list = daoServices.findBypackageId(pk.getPackageId());
		List<ServicesInfoTable> listall=daoServices.findAll();
		mv.addObject("AllServices", listall);
		mv.addObject("NewAddServices", list);
		return mv;
	}

	@RequestMapping("/packagesserviceslist")
	public ModelAndView getListOfPackagesServices() {
		ModelAndView mv = new ModelAndView();

		List<PackagesServicesTable> list = daoPackagesServices.findAll();

		mv.addObject("packagesservices", list);
		mv.setViewName("showpackagesservices");
		return mv;
	}

	@PostMapping(path = "/packagesservicesinsert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertPackagesServices(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestParam int packageId, @RequestParam int serviceId) throws Exception {
		PackagesServicesTablePK pst = new PackagesServicesTablePK();
		pst.setPackageId(packageId);
		pst.setServiceId(serviceId);
		PackagesServicesTable p = new PackagesServicesTable();
		if (pst.getPackageId() != 0)
			daoPackagesServices.insertPackagesServices(p);
		return "index";
	}

	@PostMapping(path = "/packagesservicesupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updatePackagesServices(@RequestParam MultiValueMap<String, String> paramMap,
			@RequestBody PackagesServicesTable p, @RequestParam int serviceId) throws Exception {
		daoPackagesServices.updatePackgesServices(p, serviceId);
		return "index";
	}

	@PostMapping(path = "/packagesservicesdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deletePackagesServices(@RequestBody PackagesServicesTable ps) throws Exception {

		daoPackagesServices.delete(ps);
		return "index";
	}
}