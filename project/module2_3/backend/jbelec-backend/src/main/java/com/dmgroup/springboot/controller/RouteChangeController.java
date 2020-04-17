package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.RouteChange;
import com.dmgroup.springboot.service.RouteChangeService;

@RestController
@RequestMapping("/routeChange")
public class RouteChangeController {
	@Autowired
	private RouteChangeService routeChangeService;
	
	@RequestMapping("/find/all")
	public List<RouteChange> find(){
		return routeChangeService.findAll();
	}
	
	@RequestMapping("/find/one")
	public RouteChange findOne(int routechangeid){
		return routeChangeService.findOne(routechangeid);
	}
}
