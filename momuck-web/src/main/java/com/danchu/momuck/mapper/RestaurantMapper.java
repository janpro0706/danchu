package com.danchu.momuck.mapper;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.danchu.momuck.dao.RestaurantDao;
import com.danchu.momuck.vo.Restaurant;

/**
 * RestaurantMapper
 * 
 * @author lhbv1
 */
@Repository
public class RestaurantMapper implements RestaurantDao {

	private static final Logger LOG = LoggerFactory.getLogger(RestaurantMapper.class);
	private static final String NAMESPACE = "Restaurant";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Restaurant insertRestaurant(Restaurant restaurant) {
		try {
			sqlSessionTemplate.insert(NAMESPACE + ".insertRestaurant", restaurant);
		} catch (DuplicateKeyException e) {
			return null;
		}
		return restaurant;
	}

	public Restaurant selectRestaurant(int seq) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".selectRestaurant", seq);
	}

	public Restaurant updateRestaurant(Restaurant restaurant) {
		try {
			sqlSessionTemplate.insert(NAMESPACE + ".updateRestaurant", restaurant);
		} catch (DuplicateKeyException e) {
			return null;
		}
		return restaurant;
	}

	public void deleteRestaurant(String name) {
		sqlSessionTemplate.delete(NAMESPACE + ".deleteRestaurant", name);
	}

}
