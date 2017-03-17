package com.danchu.momuck.vo;

import java.sql.Timestamp;

public class Review {
	
	int seq;
	float score;
	String message;
	Timestamp created;
	int user_seq;
	int food_seq;
	int food_restaurant_seq;
	
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
	public int getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	public int getFood_seq() {
		return food_seq;
	}
	public void setFood_seq(int food_seq) {
		this.food_seq = food_seq;
	}
	public int getFood_restaurant_seq() {
		return food_restaurant_seq;
	}
	public void setFood_restaurant_seq(int food_restaurant_seq) {
		this.food_restaurant_seq = food_restaurant_seq;
	}
	
}
