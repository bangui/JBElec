package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.FiberDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;
import com.mongodb.WriteResult;

@Repository("fiberDao")
public class FiberDaoImpl implements FiberDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Fiber> findAll() {
		return mongoTemplate.findAll(Fiber.class,"fiber");
	}

	@Override
	public Fiber findOne(int FIBER_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("FIBER_ID").is(FIBER_ID)), Fiber.class,"fiber");
	}

	@Override
	public void updateStatus(int FIBER_ID) {
		Fiber fiber=findOne(FIBER_ID);
		Criteria criteria = Criteria.where("FIBER_ID").is(FIBER_ID);
		Query query = new Query(criteria);
		Update update;
		if(fiber.getStatus()==1){
			update = Update.update("status", 0);
		}else{
			update = Update.update("status", 1);
		}
		mongoTemplate.upsert(query, update, "fiber");
	}

	@Override
	public List<Station> findStation(int FIBER_ID) {
		Fiber fiber=findOne(FIBER_ID);
		return mongoTemplate.find(new Query(Criteria.where("STATION_ID").in(fiber.getSTATIONS_ID())), Station.class,"station");
	}

	@Override
	public List<Business> findBusiness(int FIBER_ID) {
		return mongoTemplate.find(new Query(Criteria.where("ROUTE.FIBERS_ID_LIST").in(FIBER_ID)), Business.class,"business");
		
	}



}
