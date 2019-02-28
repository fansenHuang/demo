package com.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.Dept;
import com.system.entity.Module;
import com.system.entity.Role;
import com.system.entity.User;
import com.system.service.DeptService;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

/**
 * 部门
 * 
 * @author wendong
 *
 *         2019年2月22日
 */
@Controller
@RequestMapping("/deptManage/")
public class DeptController {

	@Autowired
	private DeptService deptService;

	// 部门列表
	@RequestMapping("/deptlist")
	public String deptlist(Map<String, Object> map, String start, String end, String name,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws ParseException {
				
		PageHelper.startPage(page, 6);
		List<Dept> deptList = deptService.deptList(start, end, name);

		PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptList);

		map.put("pageInfo", pageInfo);

		Dept dept2 = new Dept();

		// 如果父级不存在，填充"",页面不用做判断了
		dept2.setName("");
		for (Dept dept : deptList) {
			if (dept.getpDept() == null) {

				dept.setpDept(dept2);
			}
		}

		map.put("start", start);
		map.put("end", end);
		map.put("name", name);

		return "system/dept/deptlist";
	}

	// 展示deptZtree
	@ResponseBody
	@RequestMapping("deptTree")
	public String selectDeptTree() throws JsonProcessingException {

		List<Dept> deptList = deptService.deptTree();
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(deptList);
		return zTreeJSON;

	}

	// 批量删除
	@ResponseBody
	@RequestMapping("delAll")
	public String delAll(String data) {
		String[] ids = data.split(",");
		deptService.delAll(ids);
		return "success";
	}

	// 删除
	@ResponseBody
	@RequestMapping("del")
	public String del(String data) {
		String[] ids = data.split(",");
		deptService.delAll(ids);
		return "success";

	}

	// 跳转到添加页面
	@RequestMapping("addDept")
	public String addDept(Map<String, Object> map) {

		List<Dept> deptList = deptService.deptList(null, null, null);

		map.put("deptlist", deptList);
		return "system/dept/addDept";
	}

	// 增加
	@ResponseBody
	@RequestMapping("saveDept")
	public String saveDept(Dept dept) {

		deptService.saveDept(dept);
		return "success";

	}
	
	//跳转编辑页面
	@RequestMapping("/editDept")
	public String editRole(Map<String, Object> map, Integer id) {
		
		Dept dept = deptService.selectDeptById(id);
		
		List<Dept> deptList = deptService.deptList(null, null, null);
		
		map.put("dept", dept);
		map.put("deptlist", deptList);
		
		return "system/dept/editDept";
	}

}
