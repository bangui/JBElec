package com.dmgroup.springboot.dao;

import java.util.List;

import com.dmgroup.springboot.pojo.TopoBusiness;

public interface TopoBusinessDao {
	List<TopoBusiness> findAll();
	
	TopoBusiness findOne(int TOPO_BUSINESS_ID);
}
