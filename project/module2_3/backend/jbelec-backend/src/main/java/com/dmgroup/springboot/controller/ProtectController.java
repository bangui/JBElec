package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Protect;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.ProtectService;

@RestController
@RequestMapping("/protect")
public class ProtectController {
	@Autowired
	private ProtectService protectService;
	
	@RequestMapping("/find/all")
	public List<Protect> find(){
		return protectService.findAll();
	}
	
	@RequestMapping("/find/protect")
	public Protect findOne(Integer protectid){
		return protectService.findOne(protectid);
	}
	
	@RequestMapping("/find/station")
	public List<Station> findStation(Integer protectid){
		return protectService.findStation(protectid);
	}
	
	@RequestMapping("/find/fiber")
	public List<Fiber> findFiber(Integer protectid){
		return protectService.findFiber(protectid);
	}
}
