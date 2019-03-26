package com.system.entity;

import com.core.entity.BaseEntity;

public class Module extends BaseEntity {

	private String name;// 模块名称
	private Module parentModule;// 父模块
	private String type;// 模块类型 1主菜单 2左侧菜单 3按钮 。。。
	private String remark;// 描述
	private String url;//路径
	private String checked;//是否被选中
	private String icon;//图标
	
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 为Ztree树 展现层级结构
	public Integer getpId() {
		if (parentModule != null) {
			return parentModule.getID();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

public Module getParentModule() {
		return parentModule;
	}

	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Module [name=" + name + ", parentModule=" + parentModule + ", type=" + type + ", remark=" + remark
				+ ", url=" + url + "]";
	}
	
}
