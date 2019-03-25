package com.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.User;
import com.system.mapper.ModuleMapper;
import com.system.mapper.RoleMapper;
import com.system.mapper.UsersMapper;
import com.system.service.UserService;

@Service
public class UserServerImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    
	@Resource
	private RoleMapper roleMapper;

	@Resource
	private ModuleMapper moduleMapper;


	/**
	 * 获取用户权限
	 */
	@Override
	public Set<String> findModuleListById(String userId) {
		List<String> roleList = usersMapper.findRoleIdByUserId(userId);
	
		Set<String> moduleIdsSet = new HashSet<>();
		for (String roleId : roleList) {
			moduleIdsSet.addAll(roleMapper.findModuleIdByRoleId(roleId));
		}
		List<String> moduleIdsList = new ArrayList<>(moduleIdsSet);
		Set<String> moduleNames = new HashSet<>();
		if (!moduleIdsList.isEmpty()) {
			moduleNames.addAll(moduleMapper.findModuleNameByModuleId(moduleIdsList));
		}
		return moduleNames;
	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public User findUserByUserName(String userName) {

		return usersMapper.findUserByUserName(userName);
	}

	@Override
	public List<String> findRoleIdByUserId(String userId) {

		return usersMapper.findRoleId(userId);
	}

	@Override
	public void saveUserRole(Integer[] roleIds, Integer userId) {
		
		for (Integer roleId : roleIds) {
			usersMapper.saveUserRole(userId, roleId);
		}

	}
	@Override
	public void deleteUserRole(Integer userId){
		usersMapper.deleteUserRole(userId);//重新编辑的时候 起作用 
	}

	@Override
	public List<User> userList(String start, String end, String username) {
		return usersMapper.selectUserList(start,end,username);
	}

	
	@Override
	public String selectStatusById(Integer id) {
		
		return usersMapper.selectStatusById(id);
	}

	
	@Override
	public void upodateStatus(Integer id, Integer status) {
		
		usersMapper.upodateStatus(id,status);
	}
	
	@Override
	public int addUser(User user) {
		User user1 = (User)SecurityUtils.getSubject().getPrincipal();
		user.setCreateBy(user1.getUserName());
		user.setCreateTime(new Date());
		return usersMapper.addUser(user);
	}

	@Override
	public void delAll(String[] ids) {
		
		usersMapper.delAll(ids);
	}

	@Override
	public User selectUserById(Integer id) {
		
		return usersMapper.selectUserById(id);
	}

	@Override
	public void editUser(User user) {
		User loginUser = (User)SecurityUtils.getSubject().getPrincipal();
		user.setUpdateBy(loginUser.getUserName());
		user.setUpdateTime(new Date());
		usersMapper.editUser(user);
	}

	@Override
	public Set<String> selectRole() {
		
		return usersMapper.selectRole();
	}

}
