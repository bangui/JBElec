package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;

public interface BusinessDao {
	List<Business> findAll();
	
	Business findOne(int BUSINESS_ID);
	
	List<Station> findStation(int BUSINESS_ID);
	
	List<Fiber> findFiber(int BUSINESS_ID);
	
	void update(Business business);
	
	void insert(Business business);
	
	void insertAll(List<Business> protect);
	
	void remove(int PROTECT_ID);
	
	List<Business> findByPage(Business business, Pageable pageable);

}
