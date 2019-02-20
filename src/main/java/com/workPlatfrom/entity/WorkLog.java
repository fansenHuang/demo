package com.workPlatfrom.entity;

import com.system.entity.BaseEntity;

/**
 * 日志管理 ------ 日志
 * @author Administrator
 *
 */
public class WorkLog extends BaseEntity{

	private String name;//标题
	private Integer  userid;//根据id判断谁的日志
	private String logType;//总结类型
	private String submitter;//提交人
	private Integer submitState;//提交状态 暂定 0 未审核 1审核
	private Integer state;//状态 0 未删除 1 删除
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	public Integer getSubmitState() {
		return submitState;
	}
	public void setSubmitState(Integer submitState) {
		this.submitState = submitState;
	}
	
}
