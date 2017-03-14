package com.danchu.momuck.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultView {
	
	@JsonProperty
	private String code;
	
	@JsonProperty
	private String message;
	
	public ResultView(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResultView [code=" + code + ", message=" + message + "]";
	}
}
