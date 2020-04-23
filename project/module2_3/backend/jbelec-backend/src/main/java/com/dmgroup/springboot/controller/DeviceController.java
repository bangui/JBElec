package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Device;
import com.dmgroup.springboot.service.DeviceService;

@RestController
@RequestMapping("/device")
@CrossOrigin
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/find/all")
	public List<Device> find(){
		return deviceService.findAll();
	}
	
	@RequestMapping("/find/device")
	public Device findOne(Integer deviceid){
		return deviceService.findOne(deviceid);
	}
	
}
