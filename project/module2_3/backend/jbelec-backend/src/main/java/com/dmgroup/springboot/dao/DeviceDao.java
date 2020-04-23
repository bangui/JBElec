package com.dmgroup.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Device;

public interface DeviceDao {
	List<Device> findAll();
	
	Device findOne(int deviceId);
	
	List<Device> findLine(int deviceId);
	
	List<Device> findBusiness(int deviceId);
	
	void update(Device device);
	
	void insert(Device device);
	
	void insertAll(List<Device> device);
	
	void remove(int deviceId);
	
	List<Device> findByPage(Device device, Pageable pageable);
}
