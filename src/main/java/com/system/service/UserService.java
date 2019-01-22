package com.system.service;

import java.util.List;
import java.util.Set;

import com.system.entity.User;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
public interface UserService {

	List<User> userList(String start,String end ,String username);
	
	Set<String> findModuleListById(String string);

	User findUserByUserName(String userName);

	List<String> findRoleIdByUserId(String userId);

	void saveUserRole(Integer[] roleIds, Integer userId);

	void deleteUserRole(Integer userId);
	
	/**
	 * 查询状态 是否启用
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
	 * 增加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 批量删除
	 * @param ids
	 */
	void delAll(String[] ids);

	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);

	/**
	 * 编辑
	 * @param user
	 */
	void editUser(User user);

	Set<String> selectRole();

}
