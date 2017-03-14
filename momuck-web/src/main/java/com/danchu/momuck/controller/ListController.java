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
public class ListController {
	
	@Autowired
	FoodListDao foodListDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	private String jsonString;
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, produces = "text/json; charset=UTF-8")
	public String getAllFoodList(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException
	{
		try {
			jsonString = mapper.writeValueAsString(foodListDao.selectAllFood());
		} catch (JsonProcessingException e) {
			throw e;
		}
		return jsonString;
	}
	
	@ResponseBody
	@RequestMapping(params="category", method = RequestMethod.GET, produces = "text/json; charset=UTF-8")
	public String getCategoryFoodList(HttpServletRequest req, HttpServletResponse res, @RequestParam("category") String category) throws JsonProcessingException
	{
		try {
			jsonString = mapper.writeValueAsString(foodListDao.selectCategoryFood(category));
		} catch (JsonProcessingException e) {
			throw e;
		}
		return jsonString;
	}
}
