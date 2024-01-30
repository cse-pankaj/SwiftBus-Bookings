package com.swiftbus.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminDto {
	@NotNull(message ="Username cannot be null.")
	private String userName;
	@NotNull(message ="Password cannot be null.")
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
