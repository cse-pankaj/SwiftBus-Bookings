package com.swiftbus.service;

import java.util.List;

import com.swiftbus.exception.UserException;
import com.swiftbus.model.User;

public interface IUserService {
	public User addUser(User user) throws UserException;
	public User updateUser(User user,String key) throws UserException;
	public User deleteUser(Integer userId,String key) throws UserException;
	public User viewUser(Integer userId,String key) throws UserException;
	public List<User> viewAllUsers(String key) throws UserException;
}