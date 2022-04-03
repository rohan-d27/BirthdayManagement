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

import project.dao.PackagesDAO;
import project.dao.PackagesServicesDAO;
import project.entities.PackagesInfoTable;
import project.repository.ServicesRepository;

@Controller
public class PackagesController {

	@Autowired
	PackagesDAO daoPackages;
	@Autowired
	PackagesServicesDAO daoPackagesServices;
	@Autowired
	ServicesRepository reposerv;

	@RequestMapping("/packages")
	public ModelAndView getListOfPackages() {
		ModelAndView mv = new ModelAndView();

		List<PackagesInfoTable> list = daoPackages.findAll();

		mv.addObject("packages", list);
		mv.setViewName("packages");
		return mv;
	}

	/*
	 * @RequestMapping("/packages") public ModelAndView
	 * getListOfPackagesService(@RequestParam int id) { ModelAndView mv = new
	 * ModelAndView(); List<ServicesInfoTable> list =
	 * daoPackagesServices.findbyid(id); mv.addObject("services", list);
	 * mv.setViewName("TESTPAckage"); return mv; }
	 */

	@PostMapping(path = "/packagesinsert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertPackage(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam String packageDesc,
			@RequestParam String packageName, @RequestParam double packagePrice) throws Exception {
		PackagesInfoTable pk = new PackagesInfoTable();
		pk.setPackageName(packageName);
		pk.setPackageDesc(packageDesc);
		pk.setPackagePrice(packagePrice);
		if (pk.getPackageName() != null)
			daoPackages.insertPackage(pk);
		return "index";
	}

	@PostMapping(path = "/packagesupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updatePackage(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam int packageId,
			@RequestParam String packageDesc, @RequestParam String packageName, @RequestParam double packagePrice)
			throws Exception {

		daoPackages.updatePackage(packageId, packageName, packageDesc, packagePrice);
		return "index";
	}

	@PostMapping(path = "/packagesdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deletePackage(@RequestBody PackagesInfoTable pk) throws Exception {

		daoPackages.delete(pk);
		return "index";
	}

	@PostMapping(path = "/packageedit")
	public ModelAndView editPackage(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		PackagesInfoTable p = daoPackages.findById(id).get();
		mv.addObject("packageData", p);
		mv.setViewName("PackageDetailsEdit");
		return mv;
	}
}