package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.RouteChangeDao;
import com.dmgroup.springboot.pojo.RouteChange;
import com.dmgroup.springboot.service.RouteChangeService;
@Service("routeChangeService")
public class RouteChangeServiceImpl implements RouteChangeService{
	@Autowired
	private RouteChangeDao routeChangeDao;
	@Override
	public List<RouteChange> findAll() {
		return routeChangeDao.findAll();
	}

	@Override
	public RouteChange findOne(int ROUTECHANGE_ID) {
		return routeChangeDao.findOne(ROUTECHANGE_ID);
	}

}
