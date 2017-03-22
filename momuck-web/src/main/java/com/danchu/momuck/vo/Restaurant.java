package com.danchu.momuck.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restaurant {
	
	private int seq;
	
	private String name;
	
	@JsonProperty("avg_score")
	private String avgScore;
	
	@JsonProperty("location_coord")
	private String locationCoord;
	
	@JsonProperty("location_text")
	private String locationText;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("image_main")
	private String imageMain;
	
	@JsonProperty("image_extra")
	private String imageExtra;
	
	private Date created;

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

	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	public String getLocationCoord() {
		return locationCoord;
	}

	public void setLocationCoord(String locationCoord) {
		this.locationCoord = locationCoord;
	}

	public String getLocationText() {
		return locationText;
	}

	public void setLocationText(String locationText) {
		this.locationText = locationText;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Override
	public String toString() {
		return "Restaurant [seq=" + seq + ", name=" + name + ", avgScore=" + avgScore + ", locationCoord="
				+ locationCoord + ", locationText=" + locationText + ", phoneNumber=" + phoneNumber + ", imageMain="
				+ imageMain + ", imageExtra=" + imageExtra + ", created=" + created + "]";
	}
	
}
