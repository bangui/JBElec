package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.MaintenanceDao;
import com.dmgroup.springboot.pojo.Maintenance;
import com.dmgroup.springboot.service.MaintenanceService;
@Service("maintenanceService")
public class MaintenanceServiceImpl implements MaintenanceService{
	@Autowired
	private MaintenanceDao maintenanceDao;
	
	@Override
	public List<Maintenance> findAll() {
		return maintenanceDao.findAll();
	}

	@Override
	public Maintenance findOne(int MAINTAIN_ID) {
		return maintenanceDao.findOne(MAINTAIN_ID);
	}

}
