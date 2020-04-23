package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;

public interface BusinessDao {
	List<Business> findAll();
	
	Business findOne(int businessId);
	
	List<Station> findStation(int businessId);
	
	List<Fiber> findFiber(int businessId);
	
	void update(Business business);
	
	void insert(Business business);
	
	void insertAll(List<Business> business);
	
	void remove(int businessId);
	
	List<Business> findByPage(Business business, Pageable pageable);

}
