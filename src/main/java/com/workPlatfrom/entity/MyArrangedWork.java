package com.workPlatfrom.entity;

import java.util.Date;

import com.system.entity.BaseEntity;
import com.system.entity.User;

/**
 * @author Administrator
 *
 */
public class MyArrangedWork extends BaseEntity{

	private String name;//计划标题
	private Integer userId;
	private Integer executorId;//执行人
	private Integer verifierId;//审核人
	private Integer finishjob;//完成程度  0 未审核 1 未开始（审核通过） 2 未通过 3正在进行 4 结束 
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private Integer state;//0 未删除 1 删除
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getExecutorId() {
		return executorId;
	}
	public void setExecutorId(Integer executorId) {
		this.executorId = executorId;
	}
	public Integer getVerifierId() {
		return verifierId;
	}
	public void setVerifierId(Integer verifierId) {
		this.verifierId = verifierId;
	}
	public Integer getFinishjob() {
		return finishjob;
	}
	public void setFinishjob(Integer finishjob) {
		this.finishjob = finishjob;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
