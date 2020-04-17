package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.RouteChange;

public interface RouteChangeDao {
	
	List<RouteChange> findAll();
	
	RouteChange findOne(int ROUTECHANGE_ID);
	
}
