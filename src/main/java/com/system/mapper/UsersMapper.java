package com.system.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.User;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
@Repository
public interface UsersMapper {
   
	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(@Param("userName")String userName);

	/**
	 * 根据用户ID查询用户角色表
	 * 
	 * @param userId
	 * @return
	 */
	public List<String> findRoleIdByUserId(String userId);
	
	/**
	 * 上面这个用于用户权限 这个用于是用户列表
	 * @param userId
	 * @return
	 */
	public List<String> findRoleId(String userId);
	
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

	/**
	 * 
	 * @param start
	 * @param end
	 * @param userName
	 * @return
	 */
	List<User> selectUserList(@Param("startTime")String start, @Param("endTime")String end, @Param("userName")String userName);

	/**
	 * 查询状态 是否启用
	 * @param id
	 * @return
	 */
	String selectStatusById(@Param("id")Integer id);
	
	/**
	 * 更新状态
	 * @param id
	 * @param status
	 */
	void upodateStatus(@Param("id")Integer id, @Param("status")Integer status);

	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 批量删除
	 * @param ids
	 */
	void delAll(@Param("ids")String[] ids);

	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	public User selectUserById(@Param("id")Integer id);

	/**
	 * 编辑
	 * @param user
	 */
	public void editUser(User user);

	public Set<String> selectRole();
}