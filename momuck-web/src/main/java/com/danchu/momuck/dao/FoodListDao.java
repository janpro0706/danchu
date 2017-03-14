package com.danchu.momuck.dao;

import java.util.List;

import com.danchu.momuck.vo.Food;

public interface FoodListDao {
	public List<Food> selectAllFood();
	public List<Food> selectCategoryFood(String category);
}
