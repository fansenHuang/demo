package com.system.service;

import java.util.List;
import java.util.Set;

import com.system.entity.Role;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
public interface RoleService {

	int addRole(Role role);

	void addRoleModule(String id, String[] moduleIds);

	/**
	 * 查询所有角色
	 * @param start
	 * @param end
	 * @param name
	 * @return
	 */
	List<Role> roleList(String start, String end, String name);

	/**
	 * 批量删除
	 * @param ids
	 */
	void delAll(String[] ids);

	/**
	 * 查询状态 0启用 1停用
	 * @param id
	 * @return
	 */
	String selectStatusById(Integer id);

	/**
	 * 更新状态
	 * @param id
	 * @param status
	 */
	void upodateStatus(Integer id, Integer status);

	/**
	 * 通过ID查询角色
	 * @param id
	 * @return
	 */
	Role selectRoleById(Integer id);

	void saveEditRole(Role role);

	void updateRoleModule(Integer id);

	List<String> findModuleIdByRoleId(Integer id);

	Set<String> findModuleName(Integer id);
	 
}
