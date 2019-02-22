package com.system.entity;

/**
 * 角色-实体类
 * @author wendong
 *
 * 2019年2月22日
 */
public class Role extends BaseEntity {
	private String name;// 角色名
	private String remarks;// 描述
	private Integer status;// 状态 0启用 1停用 
	private String roleRule;
	
	public String getRoleRule() {
		return roleRule;
	}

	public void setRoleRule(String roleRule) {
		this.roleRule = roleRule;
	}

	private Boolean checked = false; // 为了实现回显 true/false
	
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


	

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
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
