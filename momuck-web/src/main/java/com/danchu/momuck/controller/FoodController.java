package com.danchu.momuck.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danchu.momuck.dao.FoodListDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/foods")
public class FoodController {
	
	@Autowired
	FoodListDao foodListDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	private String jsonString;
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String getFoodList(HttpServletRequest req, HttpServletResponse res, @RequestParam(value = "category", required = false) String category) throws JsonProcessingException
	{
		try {
			if(category==null)
				jsonString = mapper.writeValueAsString(foodListDao.selectFoodList());
			else
				jsonString = mapper.writeValueAsString(foodListDao.selectFoodListByCategory(category));
		} catch (JsonProcessingException e) {
			throw e;
		}
		return jsonString;
	}
}
