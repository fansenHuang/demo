package com.system.controller;

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
import com.system.entity.User;
import com.system.service.DeptService;

/**
 * 部门
 * @author wendong
 *
 * 2019年2月22日
 */
@Controller
@RequestMapping("/deptManage/")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	//部门列表
	@RequestMapping("/deptlist")
	public String deptlist(Map<String, Object> map, String start, String end, String deptName,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		PageHelper.startPage(page, 6);
		List<Dept> deptList = deptService.deptList(start, end, deptName);

		PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptList);

		map.put("pageInfo", pageInfo);

		map.put("start", start);
		map.put("end", end);
		map.put("deptName", deptName);

		return "system/dept/deptList";
	}
	
	//展示deptZtree
	@ResponseBody
    @RequestMapping("deptTree")
	public String selectDeptTree() throws JsonProcessingException{
    	
    	List<Dept> deptList = deptService.deptTree();
    	ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(deptList);
		return zTreeJSON;
		
		
	} 
	
	@ResponseBody
	@RequestMapping("andNode")
	public String andNode(String node,Integer parentId) throws JsonProcessingException{
		Dept dept = new Dept();
		dept.setName(node);
		deptService.andDept(dept);
		List<Dept> list =  new ArrayList<>();
		list.add(dept);
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(list);
		return zTreeJSON;
	} 

}
