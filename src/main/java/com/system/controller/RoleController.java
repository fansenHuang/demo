package com.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.entity.Module;
import com.system.entity.Role;
import com.system.service.ModuleService;
import com.system.service.RoleService;

/**
 * 角色
 * @author wendong
 *
 * 2019年2月22日
 */
@Controller
@RequestMapping("/role/")
public class RoleController {

	@Resource
	private RoleService roleService;

	@Resource
	private ModuleService moduleService;

	@ResponseBody
	@RequestMapping("addRole")
	public String addRole(Role role) {

		roleService.addRole(role);

		return "redirect:/rolelist";// ajax请求 不能重定向
	}

	@ResponseBody
	@RequestMapping("saveEditRole")
	public String saveEditRole(Role role) {

		roleService.saveEditRole(role);

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

	// 添加权限页面
	@RequestMapping("addRoleModule")
	public String addRoleModule(Model model, Integer id) throws JsonProcessingException {

		List<String> m_List = roleService.findModuleIdByRoleId(id);
		List<Module> moduleList = moduleService.modulelist(null, null);
		for (Module module : moduleList) {
			if (m_List.contains(module.getID().toString())) {
				module.setChecked("true");
			}
		}

		model.addAttribute("moduleList", moduleList);
		model.addAttribute("id", id);
		return "system/role/addRoleModule";
	}

	@RequestMapping("saveRoleModule")
	public String saveRoleModule(String ID, String[] moduleIds) {

		// 把原先的角色模块删除
		roleService.updateRoleModule(Integer.parseInt(ID));
		
		roleService.addRoleModule(ID, moduleIds);

		return "redirect:/rolelist";
	}

}
