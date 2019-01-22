package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.Role;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
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

	/**
	 * 查询所有角色
	 * @param start
	 * @param end
	 * @param name
	 * @return
	 */
	List<Role> roleList(@Param("startTime")String start, @Param("endTime")String end, @Param("name")String name);

	/**
	 * 批量删除
	 * @param ids
	 */
	void delAll(@Param("ids")String[] ids);

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
	void upodateStatus(@Param("id")Integer id, @Param("status")Integer status);

	/**
	 * 通过id查询角色
	 * @param id
	 * @return
	 */
	Role selectRoleById(Integer id);

	void saveEditRole(Role role);

	void updateRoleModule(@Param("id")Integer id);


}