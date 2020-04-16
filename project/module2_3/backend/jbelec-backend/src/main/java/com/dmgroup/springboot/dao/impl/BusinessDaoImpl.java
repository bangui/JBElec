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

import com.dmgroup.springboot.dao.BusinessDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Route;
import com.dmgroup.springboot.pojo.Station;

@Repository("businessDao")
public class BusinessDaoImpl implements BusinessDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Business> findAll() {
		return mongoTemplate.findAll(Business.class,"business");
	}

	@Override
	public Business findOne(int PROTECT_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("BUSINESS_ID").is(PROTECT_ID)), Business.class,"business");
	}

	@Override
	public void update(Business protect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Business protect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAll(List<Business> protect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int PROTECT_ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Business> findByPage(Business protect, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> findStation(int PROTECT_ID) {
		Business protect=findOne(PROTECT_ID);
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
		Business protect=findOne(PROTECT_ID);
		Set <Integer>fibersIdList=new HashSet<Integer>();
		for(Route route : protect.getROUTE()){
			for(Integer fiberId : route.getSTATIONS_ID_LIST()){
				fibersIdList.add(fiberId);
			}
		}
		return mongoTemplate.find(new Query(Criteria.where("FIBER_ID").in(fibersIdList)), Fiber.class,"fiber");
		
	}

}
