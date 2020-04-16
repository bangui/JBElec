package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.AlarmDao;
import com.dmgroup.springboot.pojo.Alarm;
import com.dmgroup.springboot.service.AlarmService;
@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{
	@Autowired
	private	AlarmDao alarmDao;
	
	@Override
	public List<Alarm> findAll() {
		return alarmDao.findAll();
	}

	@Override
	public Alarm findOne(int ALARM_ID) {
		return alarmDao.findOne(ALARM_ID);
	}

}
