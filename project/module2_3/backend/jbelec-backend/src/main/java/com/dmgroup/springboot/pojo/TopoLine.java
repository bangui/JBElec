package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class TopoLine implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String _id;
	private int TOPO_LINE_ID;
	private String TOPO_LINE_TYPE;
	private List<String> DEVICES_NAME;
	private List<Integer> DEVICES_ID;
	private int FIBER_ID;
	private String FIBER_NAME;
	private String FIBER_FULL_NAME;
	private String FIBER_TYPE;
	private String VOLTAGE_CLASS;
	private String PROPERTY_DEPT;	
	private String OBJ_DIPIDX;
	private String AUTHORITY_UNIT;	
	private String FIBERTYPE;
	private String POWER_LEVEL;	
	private String PROUNIT;
	private String AUUNIT;
	
	public int getTOPO_LINE_ID() {
		return TOPO_LINE_ID;
	}
	public void setTOPO_LINE_ID(int tOPO_LINE_ID) {
		TOPO_LINE_ID = tOPO_LINE_ID;
	}
	public String getTOPO_LINE_TYPE() {
		return TOPO_LINE_TYPE;
	}
	public void setTOPO_LINE_TYPE(String tOPO_LINE_TYPE) {
		TOPO_LINE_TYPE = tOPO_LINE_TYPE;
	}
	public List<String> getDEVICES_NAME() {
		return DEVICES_NAME;
	}
	public void setDEVICES_NAME(List<String> dEVICES_NAME) {
		DEVICES_NAME = dEVICES_NAME;
	}
	public List<Integer> getDEVICES_ID() {
		return DEVICES_ID;
	}
	public void setDEVICES_ID(List<Integer> dEVICES_ID) {
		DEVICES_ID = dEVICES_ID;
	}
	public int getFIBER_ID() {
		return FIBER_ID;
	}
	public void setFIBER_ID(int fIBER_ID) {
		FIBER_ID = fIBER_ID;
	}
	public String getFIBER_NAME() {
		return FIBER_NAME;
	}
	public void setFIBER_NAME(String fIBER_NAME) {
		FIBER_NAME = fIBER_NAME;
	}
	public String getFIBER_FULL_NAME() {
		return FIBER_FULL_NAME;
	}
	public void setFIBER_FULL_NAME(String fIBER_FULL_NAME) {
		FIBER_FULL_NAME = fIBER_FULL_NAME;
	}
	public String getFIBER_TYPE() {
		return FIBER_TYPE;
	}
	public void setFIBER_TYPE(String fIBER_TYPE) {
		FIBER_TYPE = fIBER_TYPE;
	}
	public String getVOLTAGE_CLASS() {
		return VOLTAGE_CLASS;
	}
	public void setVOLTAGE_CLASS(String vOLTAGE_CLASS) {
		VOLTAGE_CLASS = vOLTAGE_CLASS;
	}
	public String getPROPERTY_DEPT() {
		return PROPERTY_DEPT;
	}
	public void setPROPERTY_DEPT(String pROPERTY_DEPT) {
		PROPERTY_DEPT = pROPERTY_DEPT;
	}
	public String getOBJ_DIPIDX() {
		return OBJ_DIPIDX;
	}
	public void setOBJ_DIPIDX(String oBJ_DIPIDX) {
		OBJ_DIPIDX = oBJ_DIPIDX;
	}
	public String getAUTHORITY_UNIT() {
		return AUTHORITY_UNIT;
	}
	public void setAUTHORITY_UNIT(String aUTHORITY_UNIT) {
		AUTHORITY_UNIT = aUTHORITY_UNIT;
	}
	public String getFIBERTYPE() {
		return FIBERTYPE;
	}
	public void setFIBERTYPE(String fIBERTYPE) {
		FIBERTYPE = fIBERTYPE;
	}
	public String getPOWER_LEVEL() {
		return POWER_LEVEL;
	}
	public void setPOWER_LEVEL(String pOWER_LEVEL) {
		POWER_LEVEL = pOWER_LEVEL;
	}
	public String getPROUNIT() {
		return PROUNIT;
	}
	public void setPROUNIT(String pROUNIT) {
		PROUNIT = pROUNIT;
	}
	public String getAUUNIT() {
		return AUUNIT;
	}
	public void setAUUNIT(String aUUNIT) {
		AUUNIT = aUUNIT;
	}
}
