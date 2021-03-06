package com.system.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.Module;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
@Repository
public interface ModuleMapper {


	Module find(String moduleId);
	
	Set<String> findModuleNameByModuleId(List<String> moduleIds);

	List<Module> modulelist(@Param("name")String name, @Param("type")String type);

	void delAll(@Param("ids")String[] ids);

	void addModule(Module module);

	Module selectModuleById(Integer id);

	void saveEditModule(Module module);

}