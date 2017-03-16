package com.danchu.momuck.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danchu.momuck.dao.FoodDao;
import com.danchu.momuck.vo.Food;

@Service
public class FoodServiceImpl implements FoodService {

	private static final Logger LOG = LoggerFactory.getLogger(FoodServiceImpl.class);

	@Autowired
	private FoodDao foodDao;

	public List<Food> getFoodList(String category, int page) {
		LOG.info("getFoodList");
		if (category == null)
			return foodDao.selectFoodList(page);
		else
			return foodDao.selectFoodListByCategory(category, page);
	}
}