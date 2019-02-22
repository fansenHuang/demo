package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.Role;

@Repository
public interface RoleMapper {
 
	/**
	 * 通过角色ID查找所具有的模块权限的模块ID
	 * 
	 * @param roleId
	 * @return
	 */
	List<String> findModuleIdByRoleId(@Param("roleId")String roleId);

	/**
	 * 保存角色的权限分配
	 * 
	 * @param roleId
	 * @param moduleIds
	 */
	void saveRoleModule(@Param("roleId") String roleId, @Param("moduleId") String moduleId);

	/**
	 * 根据角色ID删除角色模块的关联值
	 * 
	 * @param roleId
	 */
	void deleteRoleModule(String roleId);

	
	int addRole(Role role);

	//查询所有角色
	List<Role> roleList(@Param("startTime")String start, @Param("endTime")String end, @Param("name")String name);

	//批量删除
	void delAll(@Param("ids")String[] ids);

	//查询状态 0启用 1停用
	String selectStatusById(Integer id);

	//更新状态
	void upodateStatus(@Param("id")Integer id, @Param("status")Integer status);

	//通过id查询角色
	Role selectRoleById(Integer id);

	void saveEditRole(Role role);

	void updateRoleModule(@Param("id")Integer id);


}