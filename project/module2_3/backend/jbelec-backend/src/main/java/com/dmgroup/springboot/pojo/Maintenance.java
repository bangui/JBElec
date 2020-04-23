package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Maintenance implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	private String TITLE;
	private int MAINTAIN_ID;
	private String TYPE;
	private String MAINTAIN_TYPE;
	private String APPLY_COMPANY;
	private String PERSON_NAME;
	private String DESCRIPTION;
	private Date START_TIME;
	private Date END_TIME;
	private int SOURCE_ID;
	private String STATUS;
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getMAINTAIN_ID() {
		return MAINTAIN_ID;
	}
	public void setMAINTAIN_ID(int mAINTAIN_ID) {
		MAINTAIN_ID = mAINTAIN_ID;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getMAINTAIN_TYPE() {
		return MAINTAIN_TYPE;
	}
	public void setMAINTAIN_TYPE(String mAINTAIN_TYPE) {
		MAINTAIN_TYPE = mAINTAIN_TYPE;
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
	public String getAPPLY_COMPANY() {
		return APPLY_COMPANY;
	}
	public void setAPPLY_COMPANY(String aPPLY_COMPANY) {
		APPLY_COMPANY = aPPLY_COMPANY;
	}
	public String getPERSON_NAME() {
		return PERSON_NAME;
	}
	public void setPERSON_NAME(String pERSON_NAME) {
		PERSON_NAME = pERSON_NAME;
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
	public Maintenance(String tITLE, int mAINTAIN_ID, String tYPE, String mAINTAIN_TYPE, String dESCRIPTION,
			Date sTART_TIME, Date eND_TIME, String aPPLY_COMPANY, String pERSON_NAME, int sOURCE_ID,
			String sTATUS) {
		super();
		TITLE = tITLE;
		MAINTAIN_ID = mAINTAIN_ID;
		TYPE = tYPE;
		MAINTAIN_TYPE = mAINTAIN_TYPE;
		DESCRIPTION = dESCRIPTION;
		START_TIME = sTART_TIME;
		END_TIME = eND_TIME;
		APPLY_COMPANY = aPPLY_COMPANY;
		PERSON_NAME = pERSON_NAME;
		SOURCE_ID = sOURCE_ID;
		STATUS = sTATUS;
	}
}
