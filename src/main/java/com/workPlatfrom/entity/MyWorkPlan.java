package com.workPlatfrom.entity;

import java.util.Date;

import com.system.entity.BaseEntity;
import com.system.entity.User;

/**
 * 我的工作计划
 * @author Administrator
 *
 */
public class MyWorkPlan extends BaseEntity{

	private String name;//计划标题
	private Integer userId;//确定谁的计划
	private User user;//审核人
	private Integer finishjob;//完成程度  0 未审核 1 未开始（审核通过） 2 未通过 3正在进行 4 结束 
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private Integer state;//0 未删除 1 删除
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	
	
}
