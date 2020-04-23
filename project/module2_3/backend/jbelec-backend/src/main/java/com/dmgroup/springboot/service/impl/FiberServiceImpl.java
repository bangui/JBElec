package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.FiberDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.FiberService;

@Service("fiberService")
public class FiberServiceImpl implements FiberService{
	@Autowired
	private FiberDao fiberDao;
	
	@Override
	public List<Fiber> findAll() {
		return fiberDao.findAll();
	}

	@Override
	public Fiber findOne(int FIBER_ID) {
		return fiberDao.findOne(FIBER_ID);
	}


	@Override
	public List<Station> findStation(int FIBER_ID) {
		return fiberDao.findStation(FIBER_ID);
	}

	@Override
	public List<Business> findBusiness(int FIBER_ID) {
		return fiberDao.findBusiness(FIBER_ID);
	}

	@Override
	public void updateStatus(int fiberId) {
		fiberDao.updateStatus(fiberId);
	}

}
