package com.dmgroup.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.TopoLineDao;
import com.dmgroup.springboot.pojo.TopoLine;
@Repository("topoLineDao")
public class TopoLineDaoImpl implements TopoLineDao{

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<TopoLine> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(TopoLine.class,"topoLine");
	}

	@Override
	public TopoLine findOne(int TOPO_LINE_ID) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(new Query(Criteria.where("TOPO_LINE_ID").is(TOPO_LINE_ID)), TopoLine.class,"topoLine");
		
	}

}
