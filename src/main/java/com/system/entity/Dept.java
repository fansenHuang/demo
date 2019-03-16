package com.system.entity;

import com.core.entity.BaseEntity;

public class Dept extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//部门名称
	private Dept pDept;//上级部门
	
	//ztree展示
	public Integer  getpId(){
		if (pDept != null) {
			return pDept.getID();
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Dept getpDept() {
		return pDept;
	}
	public void setpDept(Dept pDept) {
		this.pDept = pDept;
	}
	@Override
	public String toString() {
		return "Dept [name=" + name + ", pDept=" + pDept + "]";
	}
	
	
	
}
