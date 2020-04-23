package com.dmgroup.springboot.service;

import java.util.Date;
import java.util.List;

import com.dmgroup.springboot.pojo.Maintenance;

public interface MaintenanceService {
	List<Maintenance> findAll();
	
	Maintenance findOne(int MAINTAIN_ID);
	
	void insert(String title,String description,String type,String maintainType,Date startTime,Date endTime,String applyCompany,String applyPerson,int alarmId);

	void updateStatus(int maintainId,String description);
	
}
