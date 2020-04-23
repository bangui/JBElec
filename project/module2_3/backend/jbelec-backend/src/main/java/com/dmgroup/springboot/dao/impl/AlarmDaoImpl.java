package com.dmgroup.springboot.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

	@Override
	public void insert(String title, String description, String level, String personName, String source, int fiberId) {
		int id=findAll().size(); 
		Date startTime=new Date();
		Alarm alarm=new Alarm(title,id,level,description,startTime,null,source,personName,"光缆",fiberId,"处理中");
		mongoTemplate.insert(alarm,"alarm");
	}

	@Override
	public void updateStatus(int alarmId) {
		Criteria criteria =Criteria.where("ALARM_ID").is(alarmId);
		Query query=new Query(criteria);
		Update update=Update.update("STATUS", "已归档");
		//WriteResult result=
		mongoTemplate.upsert(query, update, "alarm");
		//return result.getN();
		
	}
	
	

}
