package com.dmgroup.springboot.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.ProtectDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Protect;
import com.dmgroup.springboot.pojo.Route;
import com.dmgroup.springboot.pojo.Station;

@Repository("ProtectDao")
public class ProtectDaoImpl implements ProtectDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Protect> findAll() {
		//System.out.println("here we go");
		return mongoTemplate.findAll(Protect.class,"protect");
	}

	@Override
	public Protect findOne(int PROTECT_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("PROTECT_ID").is(PROTECT_ID)), Protect.class,"protect");
	}

	@Override
	public void update(Protect protect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Protect protect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAll(List<Protect> protect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int PROTECT_ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Protect> findByPage(Protect protect, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> findStation(int PROTECT_ID) {
		Protect protect=findOne(PROTECT_ID);
		Set <Integer>stationsIdList=new HashSet<Integer>();
		for(Route route : protect.getROUTE()){
			for(Integer stationId : route.getSTATIONS_ID_LIST()){
				stationsIdList.add(stationId);
			}
		}
		return mongoTemplate.find(new Query(Criteria.where("STATION_ID").in(stationsIdList)), Station.class,"station");
	}

	@Override
	public List<Fiber> findFiber(int PROTECT_ID) {
		Protect protect=findOne(PROTECT_ID);
		Set <Integer>fibersIdList=new HashSet<Integer>();
		for(Route route : protect.getROUTE()){
			for(Integer fiberId : route.getSTATIONS_ID_LIST()){
				fibersIdList.add(fiberId);
			}
		}
		return mongoTemplate.find(new Query(Criteria.where("FIBER_ID").in(fibersIdList)), Fiber.class,"fiber_light_path");
		
	}

}
