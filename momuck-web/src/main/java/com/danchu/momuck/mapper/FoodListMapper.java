package com.danchu.momuck.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danchu.momuck.dao.FoodListDao;
import com.danchu.momuck.view.ResultView;
import com.danchu.momuck.vo.Food;

@Repository
public class FoodListMapper implements FoodListDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String namespace = "Food";
	
	public List<Food> selectAllFood() {
		return sqlSession.selectList(namespace + ".getAllFoodList");
	}
	
	public List<Food> selectCategoryFood(String category) {
		return sqlSession.selectList(namespace + ".getCategoryFoodList", category);
	}
}
