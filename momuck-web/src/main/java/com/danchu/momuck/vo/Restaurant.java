package com.danchu.momuck.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Restaurant
 * 
 * @author lhbv1
 */
public class Restaurant {
	
	private int seq;
	
	private String name;
	
	/**
     * @TODO 에러 메세지 한글로 변경 필요, 인코딩 세팅
     */
	@Max(value=5, message="not allow type")
	@Min(value=0, message="not allow type")
	@JsonProperty("avg_score")
	private float avgScore;
	
	@JsonProperty("location_coord")
	private String locationCoord;
	
	@JsonProperty("location_text")
	private String locationText;
	
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message="not phone number")
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("image_main")
	private String imageMain;
	
	@JsonProperty("image_extra")
	private String imageExtra;
	
	private Date created;
	
	private List<Food> food;

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

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
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

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Restaurant [seq=" + seq + ", name=" + name + ", avgScore=" + avgScore + ", locationCoord="
				+ locationCoord + ", locationText=" + locationText + ", phoneNumber=" + phoneNumber + ", imageMain="
				+ imageMain + ", imageExtra=" + imageExtra + ", created=" + created + ", food=" + food + "]";
	}
	
}
