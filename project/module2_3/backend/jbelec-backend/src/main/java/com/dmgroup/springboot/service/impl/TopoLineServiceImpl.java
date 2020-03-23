package com.dmgroup.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmgroup.springboot.dao.TopoLineDao;
import com.dmgroup.springboot.pojo.TopoLine;
import com.dmgroup.springboot.service.TopoLineService;

@Service("topoLineService")
public class TopoLineServiceImpl implements TopoLineService{

	@Autowired
	private TopoLineDao topoLineDao;
	
	
	@Override
	public List<TopoLine> findAll() {
		// TODO Auto-generated method stub
		return topoLineDao.findAll();
	}

	@Override
	public TopoLine findOne(int TOPO_LINE_ID) {
		// TODO Auto-generated method stub
		return topoLineDao.findOne(TOPO_LINE_ID);
	}

}
