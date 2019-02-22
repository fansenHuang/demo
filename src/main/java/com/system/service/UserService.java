package com.system.service;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.extension.service.IService;
import com.system.entity.User;

/**
 * <p>用户访问层接口类</p>
 *
 * @author liwei
 */
public interface UserService  extends IService<User> {

	List<User> userList(String start,String end ,String username);
	
	Set<String> findModuleListById(String string);

	User findUserByUserName(String userName);

	List<String> findRoleIdByUserId(String userId);

	void saveUserRole(Integer[] roleIds, Integer userId);

	/**
	 * <p>查询状态 是否启用</p>
	 * @param id	id
	 * @return
	 */
	String selectStatusById(Integer id);

	/**
	 * <p>更新状态</p>
	 * @param id	id
	 * @param status	状态
	 */
	void upodateStatus(Integer id, Integer status);

	/**
	 * <p>增加用户</p>
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * <p>批量删除</p>
	 * @param ids
	 */
	void delAll(String[] ids);

	/**
	 * <p>通过id查询用户</p>
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);

	/**
	 * <p>编辑</p>
	 * @param user
	 */
	void editUser(User user);

	Set<String> selectRole();

}
