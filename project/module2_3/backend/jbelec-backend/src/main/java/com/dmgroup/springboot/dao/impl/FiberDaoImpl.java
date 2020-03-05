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
import com.dmgroup.springboot.pojo.Protect;
import com.dmgroup.springboot.pojo.Station;

@Repository("fiberDao")
public class FiberDaoImpl implements FiberDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Fiber> findAll() {
		return mongoTemplate.findAll(Fiber.class,"fiber_light_path");
	}

	@Override
	public Fiber findOne(int FIBER_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("FIBER_ID").is(FIBER_ID)), Fiber.class,"fiber_light_path");
	}

	@Override
	public void update(Fiber fiber) {

		Criteria criteria = Criteria.where("_id").is(fiber.get_id());
		Query query = new Query(criteria);
		//Update update = Update.update("FIBER_NAME", fiber.getFIBER_NAME()).set("FIBER_FULL_NAME",  fiber.getFIBER_FULL_NAME());
		//mongoTemplate.updateMulti(query, update, Station.class);
		// TODO 
		
	}

	@Override
	public void insert(Fiber fiber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAll(List<Fiber> fiber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int FIBER_ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fiber> findByPage(Fiber fiber, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> findStation(int FIBER_ID) {
		Fiber fiber=findOne(FIBER_ID);
		return mongoTemplate.find(new Query(Criteria.where("STATION_ID").in(fiber.getSTATIONS_ID())), Station.class,"station");
	}

	@Override
	public List<Protect> findProtect(int FIBER_ID) {
		return mongoTemplate.find(new Query(Criteria.where("ROUTE.FIBERS_ID_LIST").in(FIBER_ID)), Protect.class,"protect");
		
	}



}
