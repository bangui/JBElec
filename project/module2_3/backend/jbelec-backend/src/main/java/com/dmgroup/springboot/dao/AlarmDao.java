package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.Alarm;

public interface AlarmDao {
	List<Alarm> findAll();
	
	Alarm findOne(int alarmId);
	
	void insert(String title,String description,String level,String personName,String source,int fiberId);
	
	void updateStatus(int alarmId);
}
