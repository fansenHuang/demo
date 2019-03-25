package com.system.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.Module;
import com.system.entity.Role;
import com.system.entity.User;
import com.system.service.ModuleService;
import com.system.service.RoleService;
import com.system.service.UserService;

/**
 * 本来只是想只做跳转的。。。
 * @author Administrator
 *
 */
@Controller
public class MainController {

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> map) throws JsonProcessingException {

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		map.put("user", user);

		return "welcome";
	}

	@RequestMapping("/index")
	public String index(Map<String, Object> map) throws JsonProcessingException {
		
//		查询一级菜单
		List<Module> moduleList = moduleService.modulelist(null, null);
		
		map.put("moduleList", moduleList);
		return "index";
	}

	@Autowired
	private UserService userService;

	@RequestMapping("/userList")
	public String userlist(Map<String, Object> map, String start, String end, String userName,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		PageHelper.startPage(page, 6);
		List<User> userList = userService.userList(start, end, userName);

		PageInfo<User> pageInfo = new PageInfo<User>(userList);

		map.put("pageInfo", pageInfo);
		map.put("userList", userList);

		map.put("start", start);
		map.put("end", end);
		map.put("userName", userName);

		return "system/user/userList";
	}

	@RequestMapping("/userEdit")
	public String edit(Map<String, Object> map, Integer id) {

		User user = userService.selectUserById(id);
		List<String> roLeIds = userService.findRoleIdByUserId(user.getID().toString());

		List<Role> roleList = roleService.roleList(null, null, null);

		if (roLeIds != null && roLeIds.size() > 0) {

			for (String roleId : roLeIds) {
				for (Role role : roleList) {
					if (roleId.equals(role.getID().toString())) {
						role.setChecked(true);
					}
				}
			}

		}
		map.put("user", user);
		map.put("roleList", roleList);

		return "system/user/userEdit";
	}

	@RequestMapping("/addUser")
	public String addUser(Map<String, Object> map) {
		
		List<Role> roleList = roleService.roleList(null, null, null);

		map.put("roleList", roleList);
		return "system/user/addUser";
	}

	@Resource
	private RoleService roleService;

	@RequestMapping("/roleList")
	public String role(Map<String, Object> map, String start, String end, String name,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		PageHelper.startPage(page, 6);
		List<Role> roleList = roleService.roleList(start, end, name);

		PageInfo<Role> pageInfo = new PageInfo<>(roleList);

		for (Role role : roleList) {

			Set<String> moduleNames = roleService.findModuleName(role.getID());
			if (moduleNames == null) {
				role.setRoleRule("");
			} else {
				role.setRoleRule(moduleNames.toString());
			}

		}
		map.put("pageInfo", pageInfo);
		map.put("userList", roleList);

		map.put("start", start);
		map.put("end", end);
		map.put("name", name);

		return "system/role/roleList";
	}

	@RequestMapping("/addRole")
	public String addRole() {
		return "system/role/addRole";
	}

	@RequestMapping("/editRole")
	public String editRole(Map<String, Object> map, Integer id) {
		Role role = roleService.selectRoleById(id);
		map.put("role", role);
		return "system/role/editRole";
	}

	@Resource  
	private ModuleService moduleService;

	@RequestMapping("/moduleList")
	public String modulelist(Map<String, Object> map, String name, String type,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		PageHelper.startPage(page, 6);
		List<Module> modulelist = moduleService.modulelist(name, type);
		Set<String> typeSet = new TreeSet<>();

		List<Module> modulelist2 = moduleService.modulelist(null, null);//偷个懒，不单独写查询类型的sql了
		
		for (Module module3 : modulelist2) {
			typeSet.add(module3.getType());
		}
		
		PageInfo<Module> pageInfo = new PageInfo<>(modulelist);
		
		map.put("typeSet", typeSet);
		
		map.put("pageInfo", pageInfo);

		map.put("name", name);
		map.put("type", type);

		Module module2 = new Module();
		
		// 如果父级不存在，填充"",页面不用做判断了
		module2.setName("");
		for (Module module : modulelist) {
			if (module.getParentModule() == null) {

				module.setParentModule(module2);
			}
		}

		return "system/module/modulelist";
	}

	@RequestMapping("/addModule")
	public String addModule(Map<String, Object> map) {

		List<Module> modulelist = moduleService.modulelist(null, null);

		Set<String> typeSet = new TreeSet<>();

		for (Module module : modulelist) {
			typeSet.add(module.getType());
		}

		map.put("modulelist", modulelist);
		map.put("typeSet", typeSet);

		return "system/module/addModule";
	}

	@RequestMapping("/editModule")
	public String editModule(Map<String, Object> map, Integer id) {

		Module module = moduleService.selectModuleById(id);
		
		List<Module> modulelist = moduleService.modulelist(null, null);
		Set<String> typeSet = new TreeSet<>();

		for (Module module3 : modulelist) {
			typeSet.add(module3.getType());
		}

		map.put("module", module);
		map.put("modulelist", modulelist);
		map.put("typeSet", typeSet);

		return "system/module/editModule";
	}

}
