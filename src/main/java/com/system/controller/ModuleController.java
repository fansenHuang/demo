package com.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.util.MD5Hash;
import com.system.entity.Module;
import com.system.entity.User;
import com.system.service.ModuleService;

@Controller
@RequestMapping("/module/")
public class ModuleController {

	@Resource
	private ModuleService moduleService;

	// 批量删除
	@ResponseBody
	@RequestMapping("delAll")
	public String delAll(String data) {

		String[] ids = data.split(",");
		moduleService.delAll(ids);
		return "success";
	}

	// 删除
	@ResponseBody
	@RequestMapping("del")
	public String del(String data) {
		String[] ids = data.split(",");
		moduleService.delAll(ids);
		return "success";

	}

	// 增加模块
	@ResponseBody
	@RequestMapping("addModule")
	public String addModule(Module module) {

		moduleService.addModule(module);
		return "success";

	}

	// 编辑模块
	@ResponseBody
	@RequestMapping("saveEditModule")
	public String saveEditModule(Module module) {

		moduleService.saveEditModule(module);
		return "success";

	}

}
