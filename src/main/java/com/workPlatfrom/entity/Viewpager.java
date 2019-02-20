package com.workPlatfrom.entity;

import com.system.entity.BaseEntity;

/**
 * 宣传管理--轮播图
 * @author Administrator
 *
 */
public class Viewpager extends BaseEntity {

	private String name;//名称
	private String positionSummary;//位置简介
	private String imgUrl;//图片地址
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPositionSummary() {
		return positionSummary;
	}
	public void setPositionSummary(String positionSummary) {
		this.positionSummary = positionSummary;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
}
