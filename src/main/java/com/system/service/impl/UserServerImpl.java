package com.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.entity.User;
import com.system.mapper.ModuleMapper;
import com.system.mapper.RoleMapper;
import com.system.mapper.UsersMapper;
import com.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServerImpl  extends ServiceImpl<UsersMapper, User> implements UserService  {

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private ModuleMapper moduleMapper;


	/**
	 * 获取用户权限
	 */
	@Override
	public Set<String> findModuleListById(String userId) {
		List<String> roleList = this.baseMapper.findRoleIdByUserId(userId);
		Set<String> moduleIdsSet = new HashSet<>();
		for (String roleId : roleList) {
			moduleIdsSet.addAll(roleMapper.findModuleIdByRoleId(roleId));
		}
		List<String> moduleIdsList = new ArrayList<>(moduleIdsSet);
		Set<String> moduleNames = new HashSet<>();
		moduleNames.addAll(moduleMapper.findModuleNameByModuleId(moduleIdsList));
		return moduleNames;
	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public User findUserByUserName(String userName) {
        QueryWrapper<User> weapper = new QueryWrapper<>();
        weapper.eq("user_name", userName);
		return this.getOne(weapper);
	}

	@Override
	public List<String> findRoleIdByUserId(String userId) {

		return this.baseMapper.findRoleIdByUserId(userId);
	}

	@Override
	public void saveUserRole(Integer[] roleIds, Integer userId) {
		//重新编辑的时候 起作用
		this.baseMapper.deleteUserRole(userId);

		for (Integer roleId : roleIds) {
			this.baseMapper.saveUserRole(userId, roleId);
		}

	}

	@Override
	public List<User> userList(String start, String end, String username) {
		return this.baseMapper.selectUserList(start,end,username);
	}


	@Override
	public String selectStatusById(Integer id) {

		return this.baseMapper.selectStatusById(id);
	}


	@Override
	public void upodateStatus(Integer id, Integer status) {

		this.baseMapper.upodateStatus(id,status);
	}

	@Override
	public int addUser(User user) {
		User user1 = (User)SecurityUtils.getSubject().getPrincipal();
		user.setCreateBy(user1.getUserName());
		user.setCreateTime(new Date());
		return this.baseMapper.addUser(user);
	}

	@Override
	public void delAll(String[] ids) {

		this.baseMapper.delAll(ids);
	}

	@Override
	public User selectUserById(Integer id) {

		return this.baseMapper.selectUserById(id);
	}

	@Override
	public void editUser(User user) {
		User loginUser = (User)SecurityUtils.getSubject().getPrincipal();
		user.setUpdateBy(loginUser.getUserName());
		user.setUpdateTime(new Date());
		this.baseMapper.editUser(user);
	}

	@Override
	public Set<String> selectRole() {

		return this.baseMapper.selectRole();
	}

}
