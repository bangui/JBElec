package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.TopoBusiness;
import com.dmgroup.springboot.service.TopoBusinessService;

@RestController
@RequestMapping("/topoService")

public class TopoBusinessController {
	@Autowired
	private TopoBusinessService topoBusinessService;
	
	@RequestMapping("/find/all")
	public List<TopoBusiness> find(){
		return topoBusinessService.findAll();
	}
	
	@RequestMapping("/find/topoService")
	public TopoBusiness findOne(Integer topoBusinessid) {	
		return topoBusinessService.findOne(topoBusinessid);
	}
}
