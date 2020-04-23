package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;

public interface FiberDao {
	List<Fiber> findAll();
	
	Fiber findOne(int fiberId);
	
	List<Station> findStation(int fiberId);
	
	List<Business> findBusiness(int fiberId);
	
	void updateStatus(int fiberId);
	
//	void insert(Fiber fiber);
//	
//	void insertAll(List<Fiber> fiber);
//	
//	void remove(int fiberId);
//	
//	List<Fiber> findByPage(Fiber fiber, Pageable pageable);

}
