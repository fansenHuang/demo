package com.system.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.User;

@Repository
public interface UsersMapper {
   
	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName);

	/**
	 * 根据用户ID查询用户角色表
	 * 
	 * @param userId
	 * @return
	 */
	public List<String> findRoleIdByUserId(String userId);

	/**
	 * 根据userId删除用户角色关联信息
	 * 
	 * @param userId
	 */
	public void deleteUserRole(Integer userId);

	/**
	 * 保存用户角色关联信息
	 * 
	 * @param userId
	 * @param roleId
	 */
	public void saveUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

	List<User> selectUserList(@Param("startTime")String start, @Param("endTime")String end, @Param("username")String username);

	//查询状态 是否启用
	String selectStatusById(@Param("id")Integer id);
	
	//更新状态
	void upodateStatus(@Param("id")Integer id, @Param("status")Integer status);

	//增加用户
	int addUser(User user);

	//批量删除
	void delAll(@Param("ids")String[] ids);

	//通过id查询用户
	public User selectUserById(@Param("id")Integer id);

	//编辑
	public void editUser(User user);

	public Set<String> selectRole();
}