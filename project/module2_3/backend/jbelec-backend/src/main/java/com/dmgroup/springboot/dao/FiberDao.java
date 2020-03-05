package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Protect;
import com.dmgroup.springboot.pojo.Station;

public interface FiberDao {
	List<Fiber> findAll();
	
	Fiber findOne(int FIBER_ID);
	
	List<Station> findStation(int FIBER_ID);
	
	List<Protect> findProtect(int FIBER_ID);
	
	void update(Fiber fiber);
	
	void insert(Fiber fiber);
	
	void insertAll(List<Fiber> fiber);
	
	void remove(int FIBER_ID);
	
	List<Fiber> findByPage(Fiber fiber, Pageable pageable);

}
