package com.system.service;

import java.util.List;

import com.system.entity.Module;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
public interface ModuleService {

	List<Module> modulelist(String name, String type);

	void delAll(String[] ids);

	void addModule(Module module);

	Module selectModuleById(Integer id);

	void saveEditModule(Module module);

}
