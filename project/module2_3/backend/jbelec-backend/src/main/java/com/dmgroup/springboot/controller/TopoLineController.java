package com.dmgroup.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmgroup.springboot.pojo.TopoLine;
import com.dmgroup.springboot.service.TopoLineService;

@RestController
@RequestMapping("/topoLine")

public class TopoLineController {
	@Autowired
	private TopoLineService topoLineService;
	
	@RequestMapping("/find/all")
	public List<TopoLine> find(){
		return topoLineService.findAll();
	}
	
	@RequestMapping("/find/topoLine")
	public TopoLine findOne(Integer topoLineid) {	
		return topoLineService.findOne(topoLineid);
	}
}
