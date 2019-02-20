package com.system.entity;


public class Dept {

	private Integer id;//部门id
	private String name;//部门名称
	private Integer pId;//上级部门id
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", pId=" + pId + "]";
	}
	
	
}
