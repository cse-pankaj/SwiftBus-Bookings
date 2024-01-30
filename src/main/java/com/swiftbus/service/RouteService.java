package com.swiftbus.service;

import java.util.List;

import com.swiftbus.exception.RouteException;
import com.swiftbus.exception.UserException;
import com.swiftbus.model.Route;

public interface RouteService {

	public Route addRoute(Route route,String key) throws RouteException, UserException;
	
	public Route updateRoute(Route route,String key) throws RouteException, UserException;
	
	public Route deleteRoute(Integer routeId,String key) throws RouteException, UserException;
	
	public Route viewRoute(Integer routeId,String key) throws RouteException, UserException;
	
	public List<Route> viewAllRoute(String key) throws RouteException, UserException;
	
	
	
	
}
