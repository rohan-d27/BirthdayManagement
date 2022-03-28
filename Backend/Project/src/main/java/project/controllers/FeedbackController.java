package project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.dao.FeedbackDAO;
import project.entities.FeedbackTable;

@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackDAO daoFeedback;
	
	@RequestMapping("/feedback/list")
	public ModelAndView getListOfFeedbacks()
	{
		ModelAndView mv = new ModelAndView();

		List<FeedbackTable> list = daoFeedback.findAll();

		mv.addObject("feedbacks", list);  
		mv.setViewName("showfeedbacks"); 
		return mv;
	}
	
	
	
	
}