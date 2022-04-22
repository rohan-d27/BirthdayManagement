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

import project.dao.FeedbackDAO;
import project.dao.OrdersDAO;
import project.entities.CustomerInfoTable;
import project.entities.FeedbackTable;
import project.entities.OrdersInfoTable;

@Controller
public class FeedbackController {

	@Autowired
	FeedbackDAO daoFeedback;
	@Autowired
	OrdersDAO daoOrders;

	@RequestMapping("/feedbackpage")
	public String Feedbacks() {

		return "Feedback";
	}

	@RequestMapping("/feedbacklist")
	public ModelAndView getListOfFeedbacks(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("Admin") != null) {
		List<FeedbackTable> list = daoFeedback.findAll();

		mv.addObject("feedbacks", list);
		mv.setViewName("showfeedbacks");
		return mv;}
		mv.setViewName("index");
		return mv;
	}

	@PostMapping(path = "/feedbackupdate", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String updateFeedback(@RequestParam MultiValueMap<String, String> paramMap, @RequestBody FeedbackTable fb,
			@RequestParam String feedbackDetails) throws Exception {
		int id = fb.getFeedbackId();
		daoFeedback.updateFeedback(id, feedbackDetails);
		return "index";
	}

	@PostMapping(path = "/InsertFeedback", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String insertFeedback(@RequestParam MultiValueMap<String, String> paramMap, @RequestParam int orderid,
			@RequestParam String feedbackDetails, HttpSession session) throws Exception {
		if (session.getAttribute("Customer") != null) {
		CustomerInfoTable cobj = (CustomerInfoTable) session.getAttribute("Customer");
		OrdersInfoTable obj = daoOrders.findById(orderid).get();
		if(obj!=null && obj.getCustomerInfoTable().getCustomerId()==cobj.getCustomerId()) {	
		FeedbackTable fb = new FeedbackTable();
			fb.setFeedbackDetails(feedbackDetails);
			fb.setOrderId(orderid);
			daoFeedback.insertFeedback(fb);}
		
		return "index";}
		else return "index";
		
		
	}

	@PostMapping(path = "/feedbackdelete", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String deleteFeedback(@RequestBody FeedbackTable fb) throws Exception {

		daoFeedback.delete(fb);
		return "index";
	}

	@GetMapping(path = "/feedbackcustomerfeedbacklist", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ModelAndView getListOfCustomerFeedbacks(HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("Customer") != null) {
		CustomerInfoTable c = (CustomerInfoTable) request.getSession().getAttribute("customer");
		int customerId = c.getCustomerId();
		List<FeedbackTable> list = daoFeedback.findByCustomerId(customerId);
		mv.addObject("feedbacks", list);
		mv.setViewName("showcustomerfeedbacks");
		return mv;}
		mv.setViewName("index");
		return mv;
		
	}
}