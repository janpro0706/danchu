package com.danchu.momuck.dao;

import java.util.List;

import com.danchu.momuck.vo.Food;

public interface FoodListDao {
	public List<Food> selectFoodList();
	public List<Food> selectFoodListByCategory(String category);
}
