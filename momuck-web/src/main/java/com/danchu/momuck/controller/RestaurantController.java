package com.danchu.momuck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danchu.momuck.service.RestaurantService;
import com.danchu.momuck.view.ResultView;
import com.danchu.momuck.vo.Account;
import com.danchu.momuck.vo.Restaurant;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResultView register(HttpServletRequest req, HttpServletResponse res, @RequestBody Restaurant restaurant) {

		Restaurant result = restaurantService.createRestaurant(restaurant);
		if (result == null) {
			return new ResultView("500", "Duplicated email or name", null);
		}
		return new ResultView("200", "Register success", restaurant);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
	public ResultView delete(HttpServletRequest req, HttpServletResponse res, @PathVariable String restaurantName) {
		restaurantService.deleteRestaurant(restaurantName);
		return new ResultView("200", "SUCCESS", null);
	}
}
