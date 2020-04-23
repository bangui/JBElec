package com.dmgroup.springboot.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dmgroup.springboot.dao.MaintenanceDao;
import com.dmgroup.springboot.pojo.Maintenance;
@Repository("MaintenanceDao")
public class MaintenanceDaoImpl implements MaintenanceDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Maintenance> findAll() {
		return mongoTemplate.findAll(Maintenance.class,"maintenance");
	}

	@Override
	public Maintenance findOne(int MAINTAIN_ID) {
		return mongoTemplate.findOne(new Query(Criteria.where("MAINTAIN_ID").is(MAINTAIN_ID)), Maintenance.class,"maintenance");
	}

	@Override
	public void insert(String title, String description, String type, String maintainType, Date startTime,
			Date endTime, String applyCompany, String applyPerson, int alarmId) {
		int id=findAll().size();
		Maintenance maintenance=new Maintenance(title,id,type,maintainType,description,startTime,endTime,applyCompany,applyPerson,alarmId,"处理中");
		mongoTemplate.insert(maintenance,"maintenance");
	}

	@Override
	public void updateStatus(int maintainId,String description) {
		Criteria criteria =Criteria.where("MAINTAIN_ID").is(maintainId);
		Query query=new Query(criteria);
		Update statusUpdate=Update.update("STATUS", "已归档");
		Update descriptionUpdate=Update.update("DESCTIPITON", description);
		mongoTemplate.upsert(query, statusUpdate, "maintenance");
		mongoTemplate.upsert(query, descriptionUpdate, "maintenance");
		//return result.getN();
	}

}
