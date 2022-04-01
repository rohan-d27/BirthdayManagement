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
import project.entities.PackagesInfoTable;

@Controller
public class PackagesController {

	@Autowired
	PackagesDAO daoPackages;

	@RequestMapping("/package/list")
	public ModelAndView getListOfPackages() {
		ModelAndView mv = new ModelAndView();

		List<PackagesInfoTable> list = daoPackages.findAll();

		mv.addObject("packages", list);
		mv.setViewName("showpackages");
		return mv;
	}

	@PostMapping(path = "/packages/insert", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
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

	@PostMapping(path = "/packages/update", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updatePackage(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody PackagesInfoTable pk,
			@RequestParam String packageDesc, @RequestParam String packageName, @RequestParam double packagePrice)
			throws Exception {
		int id = pk.getPackageId();
		daoPackages.updatePackage(id, packageName, packageDesc, packagePrice);
		return "index";
	}

	@PostMapping(path = "/packages/delete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deletePackage(@RequestBody PackagesInfoTable pk) throws Exception {

		daoPackages.delete(pk);
		return "index";
	}
}