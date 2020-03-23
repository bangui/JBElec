package com.dmgroup.springboot.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Device implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String _id;
	private String DEVICE_NAME;
	private String DEVICE_ID;
	private String BRAND;
	private String STATION;
	public String getDEVICE_NAME() {
		return DEVICE_NAME;
	}
	public void setDEVICE_NAME(String dEVICE_NAME) {
		DEVICE_NAME = dEVICE_NAME;
	}
	public String getDEVICE_ID() {
		return DEVICE_ID;
	}
	public void setDEVICE_ID(String dEVICE_ID) {
		DEVICE_ID = dEVICE_ID;
	}
	public String getBRAND() {
		return BRAND;
	}
	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}
	public String getSTATION() {
		return STATION;
	}
	public void setSTATION(String sTATION) {
		STATION = sTATION;
	}
}
