package com.swiftbus.service;

import com.swiftbus.exception.LoginException;
import com.swiftbus.model.AdminDto;

public interface AdminLoginService {
	public String logIntoAccount(AdminDto dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}