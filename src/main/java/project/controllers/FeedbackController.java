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

import project.dao.FeedbackDAO;
import project.entities.CustomerInfoTable;
import project.entities.FeedbackTable;

@Controller
public class FeedbackController {

	@Autowired
	FeedbackDAO daoFeedback;

	@RequestMapping("/feedbacklist")
	public ModelAndView getListOfFeedbacks() {
		ModelAndView mv = new ModelAndView();

		List<FeedbackTable> list = daoFeedback.findAll();

		mv.addObject("feedbacks", list);
		mv.setViewName("showfeedbacks");
		return mv;
	}

	@PostMapping(path = "/feedbackupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateFeedback(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody FeedbackTable fb,
			@RequestParam String feedbackDetails) throws Exception {
		int id = fb.getFeedbackId();
		daoFeedback.updateFeedback(id, feedbackDetails);
		return "index";
	}

	@PostMapping(path = "/feedbackdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteFeedback(@RequestBody FeedbackTable fb) throws Exception {

		daoFeedback.delete(fb);
		return "index";
	}

	@GetMapping(path = "/feedbackcustomerfeedbacklist", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ModelAndView getListOfCustomerFeedbacks(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		CustomerInfoTable c = (CustomerInfoTable) request.getSession().getAttribute("customer");
		int customerId = c.getCustomerId();
		List<FeedbackTable> list = daoFeedback.findByCustomerId(customerId);
		mv.addObject("feedbacks", list);
		mv.setViewName("showcustomerfeedbacks");
		return mv;
	}
}