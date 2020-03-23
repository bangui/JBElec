package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.List;

public class LightPath implements Serializable{

	private static final long serialVersionUID = 1L;
	private String LIGHT_PATH_NAME;
	private String LIGHT_PATH_FULL_NAME;
	private String BRAND;
	private int NUMBER;
	private String FLAG;
	private List<String> STATIONS_NAME;
	private List<Integer> STATIONS_ID;
	
	
	
	public String getLIGHT_PATH_NAME() {
		return LIGHT_PATH_NAME;
	}

	public void setLIGHT_PATH_NAME(String lIGHT_PATH_NAME) {
		LIGHT_PATH_NAME = lIGHT_PATH_NAME;
	}

	public String getLIGHT_PATH_FULL_NAME() {
		return LIGHT_PATH_FULL_NAME;
	}

	public void setLIGHT_PATH_FULL_NAME(String lIGHT_PATH_FULL_NAME) {
		LIGHT_PATH_FULL_NAME = lIGHT_PATH_FULL_NAME;
	}

	public String getBRAND() {
		return BRAND;
	}

	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}

	public int getNUMBER() {
		return NUMBER;
	}

	public void setNUMBER(int nUMBER) {
		NUMBER = nUMBER;
	}

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	public List<String> getSTATIONS_NAME() {
		return STATIONS_NAME;
	}

	public void setSTATIONS_NAME(List<String> sTATIONS_NAME) {
		STATIONS_NAME = sTATIONS_NAME;
	}

	public List<Integer> getSTATIONS_ID() {
		return STATIONS_ID;
	}

	public void setSTATIONS_ID(List<Integer> sTATIONS_ID) {
		STATIONS_ID = sTATIONS_ID;
	}


}