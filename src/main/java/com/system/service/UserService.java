package com.system.service;

import java.util.List;
import java.util.Set;

import com.system.entity.User;

public interface UserService {

	List<User> userList(String start,String end ,String username);
	
	Set<String> findModuleListById(String string);

	User findUserByUserName(String userName);

	List<String> findRoleIdByUserId(String userId);

	void saveUserRole(String[] roleIds, String userId);

	//查询状态 是否启用
	String selectStatusById(Integer id);

	//更新状态
	void upodateStatus(Integer id, Integer status);

	//增加用户
	void addUser(User user);

	//批量删除
	void delAll(String[] ids);

	//通过id查询用户
	User selectUserById(Integer id);

	//编辑
	void editUser(User user);

	Set<String> selectRole();

}
