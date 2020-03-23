package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.TopoBusinessDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.TopoBusiness;

@Repository("topoBusinessDao")
public class TopoBusinessDaoImpl implements TopoBusinessDao{

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<TopoBusiness> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(TopoBusiness.class,"topoService");
	}

	@Override
	public TopoBusiness findOne(int TOPO_BUSINESS_ID) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(new Query(Criteria.where("TOPO_SERVICE_ID").is(TOPO_BUSINESS_ID)), TopoBusiness.class,"topoService");
	}

}
