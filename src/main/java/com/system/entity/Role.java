package com.system.entity;

public class Role extends BaseEntity {
	private String name;// 角色名
	private String remarks;// 描述
	private Integer status;// 状态 0启用 1停用 

	private String checked; // 为了实现回显 true/false
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", remarks=" + remarks + ", status=" + status + ", checked=" + checked + "]";
	}

	
	
}
