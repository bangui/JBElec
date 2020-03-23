package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.TopoBusinessDao;
import com.dmgroup.springboot.pojo.TopoBusiness;
import com.dmgroup.springboot.service.TopoBusinessService;


@Service("topoBusinessService")
public class TopoBusinessServiceImpl implements TopoBusinessService{

	@Autowired
	private TopoBusinessDao topoBusinessDao;
	
	
	@Override
	public List<TopoBusiness> findAll() {
		// TODO Auto-generated method stub
		return topoBusinessDao.findAll();
	}

	@Override
	public TopoBusiness findOne(int TOPO_BUSINESS_ID) {
		// TODO Auto-generated method stub
		return topoBusinessDao.findOne(TOPO_BUSINESS_ID);
	}

}
