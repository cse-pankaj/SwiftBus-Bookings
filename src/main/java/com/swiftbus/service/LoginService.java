package com.swiftbus.service;

import com.swiftbus.exception.LoginException;
import com.swiftbus.model.LoginDTO;

public interface LoginService {
	public String logIntoAccount(LoginDTO dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
