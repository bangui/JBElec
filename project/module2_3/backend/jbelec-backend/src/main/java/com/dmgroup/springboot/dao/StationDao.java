package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Station;

public interface StationDao {
	
	List<Station> findAll();
	
	Station findOne(int STATION_ID);
	
	List<Fiber> findFiber(int STATION_ID);
	
	List<Business> findBusiness(int STATION_ID);
	
	void update(Station station);
	
	void insert(Station station);
	
	void insertAll(List<Station> stations);
	
	void remove(int STATION_ID);
	
	List<Station> findByPage(Station station, Pageable pageable);
}
