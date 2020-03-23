package com.dmgroup.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dmgroup.springboot.pojo.Device;

public interface DeviceService {
	List<Device> findAll();
	
	Device findOne(int DEVICE_ID);
	
	List<Device> findLine(int DEVICE_ID);
	
	List<Device> findBusiness(int DEVICE_ID);
	
	void update(Device device);
	
	void insert(Device device);
	
	void insertAll(List<Device> device);
	
	void remove(int DEVICE_ID);
	
	List<Device> findByPage(Device fiber, Pageable pageable);
}
