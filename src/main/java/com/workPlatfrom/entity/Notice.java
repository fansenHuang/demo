package com.workPlatfrom.entity;

import com.system.entity.BaseEntity;

/**
 * 公告管理 ------ 公告
 * @author Administrator
 *
 */
public class Notice extends BaseEntity{

	private String name;//标题
	private Integer noticeType;//0 非群众公告 1群众公告
	private Integer state;//0  未删除 1删除
	
	
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
	public Integer getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	
}
