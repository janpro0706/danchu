package com.danchu.momuck.dao;

import java.util.List;

import com.danchu.momuck.vo.Food;


/**
 * FoodDao
 * 
 * @author lhbv1
 */
public interface FoodDao {
	public List<Food> selectFoodList(int page);
	public List<Food> selectFoodListByCategory(String category, int page);
}
