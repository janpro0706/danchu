package com.danchu.momuck.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Food {
	
	@JsonProperty("seq") private int seq;
	@JsonProperty("name") private String name;
	@JsonProperty("price") private int price;
	@JsonProperty("category") private String category;
	@JsonProperty("avg_score") private float avgScore;	
	@JsonProperty("image_main") private String imageMain;	
	@JsonProperty("image_extra") private String imageExtra;	
	@JsonProperty("created") private Date created;
	@JsonProperty("restaurant_seq") private int restaurantSeq;
	
	public Food() {
		super();
	}

	public Food(int seq, String name, int price, String category, float avgScore, String imageMain, String imageExtra,
			Date created, int restaurantSeq) {
		super();
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.category = category;
		this.avgScore = avgScore;
		this.imageMain = imageMain;
		this.imageExtra = imageExtra;
		this.created = created;
		this.restaurantSeq = restaurantSeq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}

	public String getImageMain() {
		return imageMain;
	}

	public void setImageMain(String imageMain) {
		this.imageMain = imageMain;
	}

	public String getImageExtra() {
		return imageExtra;
	}

	public void setImageExtra(String imageExtra) {
		this.imageExtra = imageExtra;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getRestaurantSeq() {
		return restaurantSeq;
	}

	public void setRestaurantSeq(int restaurantSeq) {
		this.restaurantSeq = restaurantSeq;
	}

	@Override
	public String toString() {
		return "Food [seq=" + seq + ", name=" + name + ", price=" + price + ", category=" + category + ", avgScore="
				+ avgScore + ", imageMain=" + imageMain + ", imageExtra=" + imageExtra + ", created=" + created
				+ ", restaurantSeq=" + restaurantSeq + "]";
	}
	
}
