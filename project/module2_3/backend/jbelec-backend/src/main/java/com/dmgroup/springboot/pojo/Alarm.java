package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Alarm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	private String TITLE;
	private int ALARM_ID;
	private String LEVEL;
	private String DESCRIPTION;
	private Date START_TIME;
	private Date END_TIME;
	private String SOURCE;
	private String PERSON_NAME;
	private String TYPE;
	private int SOURCE_ID;
	private String STATUS;
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getALARM_ID() {
		return ALARM_ID;
	}
	public void setALARM_ID(int aLARM_ID) {
		ALARM_ID = aLARM_ID;
	}
	public String getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public Date getSTART_TIME() {
		return START_TIME;
	}
	public void setSTART_TIME(Date sTART_TIME) {
		START_TIME = sTART_TIME;
	}
	public Date getEND_TIME() {
		return END_TIME;
	}
	public void setEND_TIME(Date eND_TIME) {
		END_TIME = eND_TIME;
	}
	public String getSOURCE() {
		return SOURCE;
	}
	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}
	public String getPERSON_NAME() {
		return PERSON_NAME;
	}
	public void setPERSON_NAME(String pERSON_NAME) {
		PERSON_NAME = pERSON_NAME;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public int getSOURCE_ID() {
		return SOURCE_ID;
	}
	public void setSOURCE_ID(int sOURCE_ID) {
		SOURCE_ID = sOURCE_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public Alarm(String tITLE, int aLARM_ID, String lEVEL, String dESCRIPTION, Date sTART_TIME, Date eND_TIME,
			String sOURCE, String pERSON_NAME, String tYPE, int sOURCE_ID, String sTATUS) {
		super();
		TITLE = tITLE;
		ALARM_ID = aLARM_ID;
		LEVEL = lEVEL;
		DESCRIPTION = dESCRIPTION;
		START_TIME = sTART_TIME;
		END_TIME = eND_TIME;
		SOURCE = sOURCE;
		PERSON_NAME = pERSON_NAME;
		TYPE = tYPE;
		SOURCE_ID = sOURCE_ID;
		STATUS = sTATUS;
	}
}
