package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class TopoBusiness implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String _id;
	private int TOPO_SERVICE_ID;	
	//"service" will change to "business"
	private String TOPO_SERVICE_NAME;
	private String SERVICE_TYPE;
	private String AREA;
	private String POWER_LEVEL;
	private String CONFIGURATION;
	private String PROTECT_NAME;
	private String CHANNEL_TYPE;
	private String A_PORT;
	private String Z_PORT;
	private String NOTE;
	private List<Integer> TOPO_LINES_ID;
	
	public int getTOPO_SERVICE_ID() {
		return TOPO_SERVICE_ID;
	}
	public void setTOPO_SERVICE_ID(int tOPO_SERVICE_ID) {
		TOPO_SERVICE_ID = tOPO_SERVICE_ID;
	}
	public String getTOPO_SERVICE_NAME() {
		return TOPO_SERVICE_NAME;
	}
	public void setTOPO_SERVICE_NAME(String tOPO_SERVICE_NAME) {
		TOPO_SERVICE_NAME = tOPO_SERVICE_NAME;
	}
	public String getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}
	public void setSERVICE_TYPE(String sERVICE_TYPE) {
		SERVICE_TYPE = sERVICE_TYPE;
	}
	public String getAREA() {
		return AREA;
	}
	public void setAREA(String aREA) {
		AREA = aREA;
	}
	public String getPOWER_LEVEL() {
		return POWER_LEVEL;
	}
	public void setPOWER_LEVEL(String pOWER_LEVEL) {
		POWER_LEVEL = pOWER_LEVEL;
	}
	public String getCONFIGURATION() {
		return CONFIGURATION;
	}
	public void setCONFIGURATION(String cONFIGURATION) {
		CONFIGURATION = cONFIGURATION;
	}
	public String getPROTECT_NAME() {
		return PROTECT_NAME;
	}
	public void setPROTECT_NAME(String pROTECT_NAME) {
		PROTECT_NAME = pROTECT_NAME;
	}
	public String getCHANNEL_TYPE() {
		return CHANNEL_TYPE;
	}
	public void setCHANNEL_TYPE(String cHANNEL_TYPE) {
		CHANNEL_TYPE = cHANNEL_TYPE;
	}
	public String getA_PORT() {
		return A_PORT;
	}
	public void setA_PORT(String a_PORT) {
		A_PORT = a_PORT;
	}
	public String getZ_PORT() {
		return Z_PORT;
	}
	public void setZ_PORT(String z_PORT) {
		Z_PORT = z_PORT;
	}
	public String getNOTE() {
		return NOTE;
	}
	public void setNOTE(String nOTE) {
		NOTE = nOTE;
	}
	public List<Integer> getTOPO_LINES_ID() {
		return TOPO_LINES_ID;
	}
	public void setTOPO_LINES_ID(List<Integer> tOPO_LINES_ID) {
		TOPO_LINES_ID = tOPO_LINES_ID;
	}
	
}
