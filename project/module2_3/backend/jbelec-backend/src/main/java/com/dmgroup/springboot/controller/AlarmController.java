package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Alarm;
import com.dmgroup.springboot.service.AlarmService;

@RestController
@RequestMapping("/alarm")
public class AlarmController {
	@Autowired
	private AlarmService alarmService;
	
	@RequestMapping("/find/all")
	public List<Alarm> find(){
		return alarmService.findAll();
	}
	
	@RequestMapping("/find/one")
	public Alarm findOne(Integer alarmid){
		return alarmService.findOne(alarmid);
	}
}
