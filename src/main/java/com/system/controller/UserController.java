package com.system.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.util.MD5Hash;
import com.system.entity.User;
import com.system.service.UserService;

/**
 * 用户
 * @author wendong
 *
 * 2019年2月22日
 */
@Controller
@RequestMapping("/user/")
public class UserController {

	@Resource
	private UserService userService;

	// 查询状态 是否启用
	@ResponseBody
	@RequestMapping("selectStatusById")
	public String selectStatusById(Integer id) {

		String status = userService.selectStatusById(id);

		return status;

	}

	// 更新状态
	@ResponseBody
	@RequestMapping("upodateStatus")
	public String upodateStatus(Integer id, Integer status) {

		userService.upodateStatus(id, status);

		return "success";

	}

	// 增加用户
	@RequestMapping("addUser")
	public String andUser(User user,@RequestParam(value="roleId",required=false)Integer[] roleIds) {
		
		
		user.setPassword(MD5Hash.getMd5HashPasswod(user.getPassword(), user.getUserName()));
		userService.addUser(user);
		if (roleIds!=null&&roleIds.length>0) {
			userService.saveUserRole(roleIds,user.getID());
		}
		
		return "redirect:/userlist";

	}

	// 批量删除
	@ResponseBody
	@RequestMapping("delAll")
	public String delAll(String data) {
		String[] ids = data.split(",");
		userService.delAll(ids);
		return "success";

	}

	// 编辑
	@ResponseBody
	@RequestMapping("editUser")
	public String editUser(User user,@RequestParam(value="roleId",required=false)Integer[] roleIds) {
		
		userService.editUser(user);
		if (roleIds!=null&&roleIds.length>0) {

			userService.saveUserRole(roleIds, user.getID());
		}

		return "redirect:/userlist";// ajax请求，不会重定向
	}

	// 删除
	@ResponseBody
	@RequestMapping("del")
	public String del(String data) {
		String[] ids = data.split(",");
		userService.delAll(ids);
		return "success";

	}

}
