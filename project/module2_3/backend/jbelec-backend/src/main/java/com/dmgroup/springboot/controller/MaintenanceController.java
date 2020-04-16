package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Maintenance;
import com.dmgroup.springboot.service.MaintenanceService;

@RestController
@RequestMapping("/maintain")
public class MaintenanceController {
	@Autowired
	private MaintenanceService maintenanceService;
	
	@RequestMapping("/find/all")
	public List<Maintenance> find(){
		return maintenanceService.findAll();
	}
	
	@RequestMapping("/find/one")
	public Maintenance findOne(Integer maintenanceid){
		return maintenanceService.findOne(maintenanceid);
	}
}
