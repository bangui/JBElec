package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.Route;
import com.dmgroup.springboot.pojo.RouteChange;

public interface RouteChangeDao {
	
	List<RouteChange> findAll();
	
	RouteChange findOne(int ROUTECHANGE_ID);
	
	void insert(int bussinessId,int alarmId,int maintainId,List<Route> route);
	
	int updateStatus();
	
}
