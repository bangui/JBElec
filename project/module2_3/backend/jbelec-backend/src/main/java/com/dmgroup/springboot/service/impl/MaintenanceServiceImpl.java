package com.dmgroup.springboot.service.impl;

import java.util.Date;
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

	@Override
	public void insert(String title, String description, String type, String maintainType, Date startTime, Date endTime,
			String applyCompany, String applyPerson, int alarmId) {
		maintenanceDao.insert(title, description, type, maintainType, startTime, endTime, applyCompany, applyPerson, alarmId);
		
	}

	@Override
	public void updateStatus(int maintainId, String description) {
		maintenanceDao.updateStatus(maintainId, description);
	}

}
