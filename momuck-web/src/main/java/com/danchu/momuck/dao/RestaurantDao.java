package com.danchu.momuck.dao;

import com.danchu.momuck.vo.Restaurant;


/**
 * RestaurantDao
 * 
 * @author lhbv1
 */
public interface RestaurantDao {
	Restaurant insertRestaurant(Restaurant restaurant);
	Restaurant selectRestaurant(int seq);
	Restaurant updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(String name);
}
