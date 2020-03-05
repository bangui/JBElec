package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Protect;
import com.dmgroup.springboot.pojo.Station;

public interface ProtectDao {
	List<Protect> findAll();
	
	Protect findOne(int PROTECT_ID);
	
	List<Station> findStation(int PROTECT_ID);
	
	List<Fiber> findFiber(int PROTECT_ID);
	
	void update(Protect protect);
	
	void insert(Protect protect);
	
	void insertAll(List<Protect> protect);
	
	void remove(int PROTECT_ID);
	
	List<Protect> findByPage(Protect protect, Pageable pageable);

}
