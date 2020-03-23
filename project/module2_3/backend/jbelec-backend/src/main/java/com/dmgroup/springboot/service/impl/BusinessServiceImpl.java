package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.BusinessDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.BusinessService;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private BusinessDao businessDao;
	
	@Override
	public List<Business> findAll() {
		return businessDao.findAll();
	}

	@Override
	public Business findOne(int BUSINESS_ID) {
		return businessDao.findOne(BUSINESS_ID);
	}

	@Override
	public void update(Business business) {
		
	}

	@Override
	public void insert(Business business) {
		
	}

	@Override
	public void insertAll(List<Business> business) {
		
	}

	@Override
	public void remove(int BUSINESS_ID) {
		
	}

	@Override
	public List<Business> findByPage(Business business, Pageable pageable) {
		return null;
	}

	@Override
	public List<Station> findStation(int BUSINESS_ID) {
		return businessDao.findStation(BUSINESS_ID);
	}

	@Override
	public List<Fiber> findFiber(int BUSINESS_ID) {
		return businessDao.findFiber(BUSINESS_ID);
	}

}
