package com.websocket.entity;

import com.core.entity.BaseEntity;

public class Notice extends BaseEntity{

	//部门类型
	private String type;
	
	//标题
	private String title;
	
	//内容
	private String content;
	
	//状态 0草稿箱 1已发布
	private Integer status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notice [type=" + type + ", title=" + title + ", content=" + content + ", status=" + status + "]";
	}

	
}
