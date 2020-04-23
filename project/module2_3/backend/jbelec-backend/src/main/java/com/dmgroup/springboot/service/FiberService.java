package com.dmgroup.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;

public interface FiberService {
	List<Fiber> findAll();
	
	Fiber findOne(int FIBER_ID);
	
	List<Station> findStation(int FIBER_ID);
	
	List<Business> findBusiness(int FIBER_ID);
	
	void updateStatus(int fiberId);
	
//	void insert(Fiber fiber);
//	
//	void insertAll(List<Fiber> fiber);
//	
//	void remove(int FIBER_ID);
//	
//	List<Fiber> findByPage(Fiber fiber, Pageable pageable);

}
