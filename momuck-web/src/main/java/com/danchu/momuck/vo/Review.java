package com.danchu.momuck.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
	
	private int seq;
	private float score;
	private String message;
	private Date created;
	
	@JsonProperty("user_seq")
	private int userSeq;
	
	@JsonProperty("food_seq")
	private int foodSeq;
	
	@JsonProperty("food_restaurant_seq")
	private int foodRestaurantSeq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getFoodSeq() {
		return foodSeq;
	}
	public void setFoodSeq(int foodSeq) {
		this.foodSeq = foodSeq;
	}
	public int getFoodRestaurantSeq() {
		return foodRestaurantSeq;
	}
	public void setFoodRestaurantSeq(int foodRestaurantSeq) {
		this.foodRestaurantSeq = foodRestaurantSeq;
	}
	
	
}
