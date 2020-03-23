package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.DeviceDao;
import com.dmgroup.springboot.pojo.Device;
import com.dmgroup.springboot.service.DeviceService;


@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceDao deviceDao;
	
	@Override
	public List<Device> findAll() {
		// TODO Auto-generated method stub
		return deviceDao.findAll();
	}

	@Override
	public Device findOne(int DEVICE_ID) {
		// TODO Auto-generated method stub
		return deviceDao.findOne(DEVICE_ID);
	}

	@Override
	public List<Device> findLine(int DEVICE_ID) {
		// TODO Auto-generated method stub
		return deviceDao.findLine(DEVICE_ID);
	}

	@Override
	public List<Device> findBusiness(int DEVICE_ID) {
		// TODO Auto-generated method stub
		return deviceDao.findBusiness(DEVICE_ID);
	}

	@Override
	public void update(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAll(List<Device> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int DEVICE_ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Device> findByPage(Device fiber, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
