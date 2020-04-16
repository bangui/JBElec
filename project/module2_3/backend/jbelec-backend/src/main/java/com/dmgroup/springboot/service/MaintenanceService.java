package com.dmgroup.springboot.service;

import java.util.List;

import com.dmgroup.springboot.pojo.Maintenance;

public interface MaintenanceService {
	List<Maintenance> findAll();
	
	Maintenance findOne(int MAINTAIN_ID);
}
