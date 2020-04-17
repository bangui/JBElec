package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.RouteChangeDao;
import com.dmgroup.springboot.pojo.RouteChange;
@Repository("RouteChangeDao")
public class RouteChangeDaoImpl implements RouteChangeDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<RouteChange> findAll() {
		return mongoTemplate.findAll(RouteChange.class, "route");
	}

	@Override
	public RouteChange findOne(int ROUTECHANGE_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("ROUTECHANGE_ID").is(ROUTECHANGE_ID)), RouteChange.class,"route");
	}

}
