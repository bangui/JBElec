package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.TopoLine;

public interface TopoLineDao {
	List<TopoLine> findAll();
	
	TopoLine findOne(int TOPO_LINE_ID);
}
