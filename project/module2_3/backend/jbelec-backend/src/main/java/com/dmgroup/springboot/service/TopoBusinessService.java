package com.dmgroup.springboot.service;

import java.util.List;

import com.dmgroup.springboot.pojo.TopoBusiness;

public interface TopoBusinessService {
	List<TopoBusiness> findAll();
	
	TopoBusiness findOne(int TOPO_BUSINESS_ID);
}
