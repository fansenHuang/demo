package com.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.system.entity.Module;
import com.system.entity.User;
import com.system.mapper.ModuleMapper;
import com.system.service.ModuleService;

/**
 * 
 * @author wendong
 *
 * 2019年3月25日
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	@Resource
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> modulelist(String name, String type) {
		
		return moduleMapper.modulelist(name,type);
	}

	@Override
	public void delAll(String[] ids) {
		
		moduleMapper.delAll(ids);
	}

	@Override
	public void addModule(Module module) {
		
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		module.setCreateBy(user.getUserName());
		module.setCreateTime(new Date());
		
		moduleMapper.addModule(module);
	}

	@Override
	public Module selectModuleById(Integer id) {
		
		return moduleMapper.selectModuleById(id);
	}

	@Override
	public void saveEditModule(Module module) {
		
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		module.setUpdateBy(user.getUserName());
		module.setUpdateTime(new Date());
		moduleMapper.saveEditModule(module);
	}

}
