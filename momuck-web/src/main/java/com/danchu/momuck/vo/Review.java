package com.danchu.momuck.vo;

import java.sql.Timestamp;

public class Review {
	
	int seq;
	float score;
	String message;
	Timestamp created;
	int userSeq;
	int foodSeq;
	int foodRestaurantSeq;
	
	public Review(){
		
	}
	
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
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
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
