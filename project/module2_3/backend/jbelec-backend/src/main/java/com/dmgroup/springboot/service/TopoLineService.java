package com.dmgroup.springboot.service;

import java.util.List;

import com.dmgroup.springboot.pojo.TopoLine;

public interface TopoLineService {
	List<TopoLine> findAll();
	
	TopoLine findOne(int TOPO_LINE_ID);
}
