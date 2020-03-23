package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.BusinessService;

@RestController
@RequestMapping("/service")
//will change /service to /business
public class BusinessController {
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("/find/all")
	public List<Business> find(){
		return businessService.findAll();
	}
	
	@RequestMapping("/find/one")
	public Business findOne(Integer businessid){
		return businessService.findOne(businessid);
	}
	
	@RequestMapping("/find/station")
	public List<Station> findStation(Integer businessid){
		return businessService.findStation(businessid);
	}
	
	@RequestMapping("/find/fiber")
	public List<Fiber> findFiber(Integer businessid){
		return businessService.findFiber(businessid);
	}
}
