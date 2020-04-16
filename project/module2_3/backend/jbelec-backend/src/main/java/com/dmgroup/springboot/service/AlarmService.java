package com.dmgroup.springboot.service;

import java.util.List;

import com.dmgroup.springboot.pojo.Alarm;

public interface AlarmService {
	List<Alarm> findAll();
	
	Alarm findOne(int ALARM_ID);
	
}
