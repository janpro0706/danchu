package com.danchu.momuck.service;

import java.util.List;

import com.danchu.momuck.vo.Restaurant;

public interface RestaurantService {

	Restaurant createRestaurant(Restaurant restaurant);

	Restaurant updateRestaurant(Restaurant restaurant);

	Restaurant selectRestaurant(int seqs);

	void deleteRestaurant(String name);

}