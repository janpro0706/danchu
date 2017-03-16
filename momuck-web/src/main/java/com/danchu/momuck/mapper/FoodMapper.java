package com.danchu.momuck.mapper;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danchu.momuck.dao.FoodDao;
import com.danchu.momuck.vo.Food;

@Repository
public class FoodMapper implements FoodDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private HashMap<String, Object> map = new HashMap<String, Object>();
	
	private static final String namespace = "Food";
	
	public List<Food> selectFoodList(int page) {
		map.put("offset", 0+10*(page-1));
		return sqlSession.selectList(namespace + ".getAllFoodList", map);
	}
	
	public List<Food> selectFoodListByCategory(String category, int page) {
		map.put("offset", 0+10*(page-1));
		map.put("category", category);
		return sqlSession.selectList(namespace + ".getCategoryFoodList", map);
	}
}
