package com.axis.dto;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
    Integer status;
    String message;
    Object data = new Object();
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
}