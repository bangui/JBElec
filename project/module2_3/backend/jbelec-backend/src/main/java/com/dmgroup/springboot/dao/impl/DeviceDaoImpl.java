package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dmgroup.springboot.dao.DeviceDao;
import com.dmgroup.springboot.pojo.Device;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("deviceDao")
public class DeviceDaoImpl implements DeviceDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Device> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Device.class,"device");
	}

	@Override
	public Device findOne(int DEVICE_ID) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(new Query(Criteria.where("DEVICE_ID").is(DEVICE_ID)), Device.class,"device");
	}

	@Override
	public List<Device> findLine(int DEVICE_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> findBusiness(int DEVICE_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAll(List<Device> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int DEVICE_ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Device> findByPage(Device fiber, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
