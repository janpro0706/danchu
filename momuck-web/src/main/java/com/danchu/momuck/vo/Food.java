package com.danchu.momuck.vo;

import java.util.Date;

public class Food {
	private int seq;
	private String name;
	private int price;
	private String category;
	private float avg_score;
	private String image_main;
	private String image_extra;
	private Date created;
	private int restaurant_seq;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(int seq, String name, int price, String category, float avg_score, String image_main,
			String image_extra, Date created, int restaurant_seq) {
		super();
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.category = category;
		this.avg_score = avg_score;
		this.image_main = image_main;
		this.image_extra = image_extra;
		this.created = created;
		this.restaurant_seq = restaurant_seq;
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

	public float getAvg_score() {
		return avg_score;
	}

	public void setAvg_score(float avg_score) {
		this.avg_score = avg_score;
	}

	public String getImage_main() {
		return image_main;
	}

	public void setImage_main(String image_main) {
		this.image_main = image_main;
	}

	public String getImage_extra() {
		return image_extra;
	}

	public void setImage_extra(String image_extra) {
		this.image_extra = image_extra;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getRestaurant_seq() {
		return restaurant_seq;
	}

	public void setRestaurant_seq(int restaurant_seq) {
		this.restaurant_seq = restaurant_seq;
	}

	@Override
	public String toString() {
		return "Food [seq=" + seq + ", name=" + name + ", price=" + price + ", category=" + category + ", avg_score="
				+ avg_score + ", image_main=" + image_main + ", image_extra=" + image_extra + ", created=" + created
				+ ", restaurant_seq=" + restaurant_seq + "]";
	}
	
	
}
