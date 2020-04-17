package com.dmgroup.springboot.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class RouteChange implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	private String _id;
	private Integer ROUTE_ID;
	private Integer BUSINESS_ID;
	private Integer ALARM_ID;
	private Integer MAINTAIN_ID;
	private List<Integer> ROUTE_STATION_LIST;
	private List<Integer> ROUTE_FIBER_LIST;
	private Integer STATE_ID;
	private Integer CURRENT_STATE_ID;
	private Integer FIBER_ID;
	
	public Integer getROUTE_ID() {
		return ROUTE_ID;
	}
	public void setROUTE_ID(Integer rOUTE_ID) {
		ROUTE_ID = rOUTE_ID;
	}
	public Integer getBUSINESS_ID() {
		return BUSINESS_ID;
	}
	public void setBUSINESS_ID(Integer bUSINESS_ID) {
		BUSINESS_ID = bUSINESS_ID;
	}
	public Integer getALARM_ID() {
		return ALARM_ID;
	}
	public void setALARM_ID(Integer aLARM_ID) {
		ALARM_ID = aLARM_ID;
	}
	public Integer getMAINTAIN_ID() {
		return MAINTAIN_ID;
	}
	public void setMAINTAIN_ID(Integer mAINTAIN_ID) {
		MAINTAIN_ID = mAINTAIN_ID;
	}
	public List<Integer> getROUTE_STATION_LIST() {
		return ROUTE_STATION_LIST;
	}
	public void setROUTE_STATION_LIST(List<Integer> rOUTE_STATION_LIST) {
		ROUTE_STATION_LIST = rOUTE_STATION_LIST;
	}
	public List<Integer> getROUTE_FIBER_LIST() {
		return ROUTE_FIBER_LIST;
	}
	public void setROUTE_FIBER_LIST(List<Integer> rOUTE_FIBER_LIST) {
		ROUTE_FIBER_LIST = rOUTE_FIBER_LIST;
	}
	public Integer getSTATE_ID() {
		return STATE_ID;
	}
	public void setSTATE_ID(Integer sTATE_ID) {
		STATE_ID = sTATE_ID;
	}
	public Integer getCURRENT_STATE_ID() {
		return CURRENT_STATE_ID;
	}
	public void setCURRENT_STATE_ID(Integer cURRENT_STATE_ID) {
		CURRENT_STATE_ID = cURRENT_STATE_ID;
	}
	public Integer getFIBER_ID() {
		return FIBER_ID;
	}
	public void setFIBER_ID(Integer fIBER_ID) {
		FIBER_ID = fIBER_ID;
	}
	
}