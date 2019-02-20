package com.workPlatfrom.entity;

import com.system.entity.BaseEntity;

/**
 * 宣传管理 ---  文章
 * @author Administrator
 *
 */
public class Article extends BaseEntity{

	private String name;//标题
	private String imgUrl;//图片地址
	private Integer articleSectionId;//所属栏目id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getArticleSectionId() {
		return articleSectionId;
	}
	public void setArticleSectionId(Integer articleSectionId) {
		this.articleSectionId = articleSectionId;
	}
	
	
	
}
