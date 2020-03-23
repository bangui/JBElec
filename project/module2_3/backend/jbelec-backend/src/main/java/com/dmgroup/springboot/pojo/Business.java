package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Business implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	private int SERVICE_ID;	
	//"service" will change to "business"
	private String LINE_NAME;
	private String SERVICE_TYPE;
	private String AREA;
	private String POWER_LEVEL;
	private String CONFIGURATION;
	private String PROTECT_NAME;
	private String CHANNEL_TYPE;
	private String A_PORT;
	private String Z_PORT;
	private List<Route> ROUTE;
	private String NOTE;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public int getSERVICE_ID() {
		return SERVICE_ID;
	}
	public void setSERVICE_ID(int sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
	}
	public String getLINE_NAME() {
		return LINE_NAME;
	}
	public void setLINE_NAME(String lINE_NAME) {
		LINE_NAME = lINE_NAME;
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
	public String getDEVICE_NAME() {
		return CONFIGURATION;
	}
	public void setDEVICE_NAME(String dEVICE_NAME) {
		CONFIGURATION = dEVICE_NAME;
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
	public List<Route> getROUTE() {
		return ROUTE;
	}
	public void setROUTE(List<Route> rOUTE) {
		ROUTE = rOUTE;
	}
	public String getNOTE() {
		return NOTE;
	}
	public void setNOTE(String nOTE) {
		NOTE = nOTE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}
	public void setSERVICE_TYPE(String sERVICE_TYPE) {
		SERVICE_TYPE = sERVICE_TYPE;
	}
}