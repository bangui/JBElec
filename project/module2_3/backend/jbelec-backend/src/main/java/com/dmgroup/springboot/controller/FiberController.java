package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Protect;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.FiberService;
@RestController
@RequestMapping("/fiber")
public class FiberController {

	@Autowired
	private FiberService fiberService;
	
	@RequestMapping("/find/all")
	public List<Fiber> find(){
		//System.out.println("here");
		return fiberService.findAll();
	}
	
	@RequestMapping("/find/fiber")
	public Fiber findOne(Integer fiberid){
		return fiberService.findOne(fiberid);
	}
	
	@RequestMapping("/find/station")
	public List<Station> findStation(Integer fiberid){
		return fiberService.findStation(fiberid);
	}
	
	@RequestMapping("/find/protect")
	public List<Protect> findProtect(Integer fiberid){
		return fiberService.findProtect(fiberid);
	}
}