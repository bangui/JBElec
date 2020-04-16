package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.Maintenance;

public interface MaintenanceDao {
	List<Maintenance> findAll();
	
	Maintenance findOne(int MAINTAIN_ID);
}
