package com.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Service;

import com.system.entity.Role;
import com.system.entity.User;
import com.system.mapper.ModuleMapper;
import com.system.mapper.RoleMapper;
import com.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private ModuleMapper moduleMapper;
	
	@Override
	public int addRole(Role role) {
		User loginUser = (User)SecurityUtils.getSubject().getPrincipal();
		role.setCreateBy(loginUser.getUsername());
		role.setCreateTime(new Date());
		return roleMapper.addRole(role);
	}

	@Override
	public void addRoleModule(String id, String[] moduleIds) {
		
		for (String moduleId : moduleIds) {
			roleMapper.saveRoleModule(id,moduleId);
		}
	}

	@Override
	public List<Role> roleList(String start, String end, String name) {
		
		return roleMapper.roleList(start,end,name);
	}

	
	@Override
	public void delAll(String[] ids) {
		
		roleMapper.delAll(ids);
	}

	@Override
	public String selectStatusById(Integer id) {
		
		
		return roleMapper.selectStatusById(id);
	}

	@Override
	public void upodateStatus(Integer id, Integer status) {
		
		roleMapper.upodateStatus(id,status);
	}

	@Override
	public Role selectRoleById(Integer id) {
		
		return roleMapper.selectRoleById(id);
	}

	@Override
	public void saveEditRole(Role role) {
		User loginUser = (User)SecurityUtils.getSubject().getPrincipal();
		role.setUpdateBy(loginUser.getUsername());
		role.setUpdateTime(new Date());
		roleMapper.saveEditRole(role);
	}

	@Override
	public void updateRoleModule(Integer id) {
		
		roleMapper.updateRoleModule(id);
	}

	@Override
	public List<String> findModuleIdByRoleId(Integer id) {
		
		return roleMapper.findModuleIdByRoleId(id.toString());
	}

	//查询权限规则--就是角色所具有的权限（模块）
	@Override
	public Set<String> findModuleName(Integer roleId) {
		
		Set<String> moduleIdsSet = new HashSet<>();
		List<String> moduleIds = roleMapper.findModuleIdByRoleId(roleId.toString());
		
		if (moduleIds!=null&&moduleIds.size()>0) {
			moduleIdsSet.addAll(roleMapper.findModuleIdByRoleId(roleId.toString()));
			List<String> moduleIdsList = new ArrayList<>(moduleIdsSet);
			Set<String> moduleNames = new HashSet<>();
			moduleNames.addAll(moduleMapper.findModuleNameByModuleId(moduleIdsList));
			
			return moduleNames;
		}
		return null;
	}

}
