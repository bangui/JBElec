package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.FiberDao;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Protect;
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
	public void update(Fiber fiber) {
		fiberDao.update(fiber);
	}

	@Override
	public void insert(Fiber fiber) {
		fiberDao.insert(fiber); 
	}

	@Override
	public void insertAll(List<Fiber> fiber) {
		fiberDao.insertAll(fiber);
	}

	@Override
	public void remove(int FIBER_ID) {
		fiberDao.remove(FIBER_ID);
	}

	@Override
	public List<Fiber> findByPage(Fiber fiber, Pageable pageable) {
		return fiberDao.findByPage(fiber, pageable);
	}

	@Override
	public List<Station> findStation(int FIBER_ID) {
		return fiberDao.findStation(FIBER_ID);
	}

	@Override
	public List<Protect> findProtect(int FIBER_ID) {
		return fiberDao.findProtect(FIBER_ID);
	}

}
