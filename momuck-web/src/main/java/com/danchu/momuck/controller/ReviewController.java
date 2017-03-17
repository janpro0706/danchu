package com.danchu.momuck.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danchu.momuck.service.ReviewService;
import com.danchu.momuck.view.ResultView;
import com.danchu.momuck.vo.Review;


@Controller
public class ReviewController {
	
	final private int USER_SEQ = 19;
	
	@Autowired
	ReviewService reviewService;
	
	@ResponseBody
    @RequestMapping(value = "/foods/{foods_id}/reviews", method = RequestMethod.POST, consumes = "application/json")
    public ResultView submitReview(@PathVariable int foods_id,@RequestBody Review review) {
    	 
    	review.setUser_seq(USER_SEQ);
    	review.setFood_seq(foods_id);
    	
    	Review result = reviewService.submitReview(review);
    	if(result!=null){
    		return new ResultView("200", "OK");
    	} 
    	 
        return new ResultView("500", "Server Internal Error");
    }
    
	@ResponseBody
    @RequestMapping(value = "/foods/{foods_id}/reviews/{reviews_id}", method = RequestMethod.POST, consumes = "application/json")
    public ResultView updateReivew(@PathVariable int reviews_id, @RequestBody Review review) {
		review.setSeq(reviews_id);
    	int result = reviewService.updateReview(review);
    	if(result < 0){
    		return new ResultView("500", "Server Internal Error");
    	} 
    	return new ResultView("200", "OK");
    }
    
    @RequestMapping(value = "/foods/{foods_id}/reviews/{reviews_id}", method = RequestMethod.DELETE)
    public String deleteReivew(@PathVariable String foods_id, @PathVariable String reviews_id, Model model) {
    	model.addAttribute("foods_id", foods_id);
    	
        return "index";
    }
    
    @RequestMapping(value = "/foods/{foods_id}/reviews", method = RequestMethod.GET)
    public String getReviewList(@PathVariable String foods_id, Model model) {
    
    	//ArrayList<Review> reviews = reviewService.listReview(model);
    	//model.addAttribute("list", reviews);
        return "index";
    }
}
