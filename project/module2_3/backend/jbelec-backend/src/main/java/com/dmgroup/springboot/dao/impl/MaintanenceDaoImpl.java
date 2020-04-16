package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.MaintenanceDao;
import com.dmgroup.springboot.pojo.Maintenance;
@Repository("MaintanenceDao")
public class MaintanenceDaoImpl implements MaintenanceDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Maintenance> findAll() {
		return mongoTemplate.findAll(Maintenance.class,"maintenance");
	}

	@Override
	public Maintenance findOne(int MAINTAIN_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("MAINTAIN_ID").is(MAINTAIN_ID)), Maintenance.class,"maintenance");
	}

}
