package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.Alarm;

public interface AlarmDao {
	List<Alarm> findAll();
	
	Alarm findOne(int ALARM_ID);
	
}
