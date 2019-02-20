package com.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.entity.Role;
import com.system.service.RoleService;

@Controller
@RequestMapping("/role/")
public class RoleController {

	@Resource
	private RoleService roleService;

	@ResponseBody
	@RequestMapping("addRole")
	public String addRole(Role role, String[] moduleId) {
		roleService.addRole(role);
		if (moduleId != null && moduleId.length > 0) {
			for (int i = 0; i < moduleId.length; i++) {
				roleService.addRoleModule(role.getID().toString(), moduleId[i]);
			}
		}
		return "redirect:/rolelist";// ajax请求 不能重定向
	}

	@ResponseBody
	@RequestMapping("saveEditRole")
	public String saveEditRole(Role role, String[] moduleId) {
		roleService.saveEditRole(role);
		
		//把原先的角色模块删除
		roleService.updateRoleModule(role.getID());
		
		if (moduleId != null && moduleId.length > 0) {
			for (int i = 0; i < moduleId.length; i++) {
				roleService.addRoleModule(role.getID().toString(), moduleId[i]);
			}
		}
		return "redirect:/rolelist";// ajax请求 不能重定向
	}
	
	// 批量删除
	@ResponseBody
	@RequestMapping("delAll")
	public String delAll(String data) {
		String[] ids = data.split(",");
		roleService.delAll(ids);
		return "success";

	}

	// 查询状态 是否启用
	@ResponseBody
	@RequestMapping("selectStatusById")
	public String selectStatusById(Integer id) {

		return roleService.selectStatusById(id);

	}

	// 更新状态
	@ResponseBody
	@RequestMapping("upodateStatus")
	public String upodateStatus(Integer id, Integer status) {

		roleService.upodateStatus(id, status);

		return "success";

	}

	// 删除
	@ResponseBody
	@RequestMapping("del")
	public String del(String data) {
		String[] ids = data.split(",");
		roleService.delAll(ids);
		return "success";

	}

}
