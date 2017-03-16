package com.danchu.momuck.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danchu.momuck.service.FoodService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String list(HttpServletRequest req, HttpServletResponse res, 
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "page") int page) throws JsonProcessingException 
	{
		
		return mapper.writeValueAsString(foodService.getFoodList(category, page));
	}
}
