package com.workPlatfrom.entity;

import com.system.entity.BaseEntity;

/**
 * 宣传管理 ---文章栏目
 * @author Administrator
 *
 */
public class ArticleSection extends BaseEntity{

	private String name;//名称
	private Integer state;//0 未删除 1 删除
	private ArticleSection articleSection;
	
	
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
	public ArticleSection getArticleSection() {
		return articleSection;
	}
	public void setArticleSection(ArticleSection articleSection) {
		this.articleSection = articleSection;
	}
	
	
}
