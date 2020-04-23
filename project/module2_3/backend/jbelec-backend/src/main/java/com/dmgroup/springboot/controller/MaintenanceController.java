package com.dmgroup.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Maintenance;
import com.dmgroup.springboot.service.MaintenanceService;

@RestController
@RequestMapping("/maintain")
@CrossOrigin
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
	
	@RequestMapping("/insert")
	public void insert(String title,String description,String type,String maintainType,Date startTime,Date endTime,String applyCompany,String applyPerson,int alarmId){
		maintenanceService.insert(title, description, type, maintainType, startTime, endTime, applyCompany, applyPerson, alarmId);
	}
	
	@RequestMapping("/update/status")
	public void updateStatus(Integer maintainid,String description){
		maintenanceService.updateStatus(maintainid, description);
	}
	
	
}
