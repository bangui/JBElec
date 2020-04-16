package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.AlarmDao;
import com.dmgroup.springboot.pojo.Alarm;
@Repository("alarmDao")
public class AlarmDaoImpl implements AlarmDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Alarm> findAll() {
		return mongoTemplate.findAll(Alarm.class,"alarm");
	}

	@Override
	public Alarm findOne(int ALARM_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("ALARM_ID").is(ALARM_ID)), Alarm.class,"alarm");
		
	}

}
