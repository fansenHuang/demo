package com.system.service;

import java.util.List;

import com.system.entity.Role;

public interface RoleService {

	int addRole(Role role);

	void addRoleModule(String id, String moduleId);

	//查询所有角色
	List<Role> roleList(String start, String end, String name);

	//批量删除
	void delAll(String[] ids);

	//查询状态 0启用 1停用
	String selectStatusById(Integer id);

	//更新状态
	void upodateStatus(Integer id, Integer status);

	//通过ID查询角色
	Role selectRoleById(Integer id);

	void saveEditRole(Role role);

	void updateRoleModule(Integer id);
	 
}
