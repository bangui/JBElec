package com.dmgroup.springboot.service;

import java.util.List;

import com.dmgroup.springboot.pojo.RouteChange;

public interface RouteChangeService {
	List<RouteChange> findAll();
	RouteChange findOne(int ROUTECHANGE_ID);
}
