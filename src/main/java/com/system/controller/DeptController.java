package com.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.entity.Dept;
import com.system.service.DeptService;

@Controller
@RequestMapping("/deptManage/")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
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
		dept.setpId(parentId);
		deptService.andDept(dept);
		List<Dept> list =  new ArrayList<>();
		list.add(dept);
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(list);
		return zTreeJSON;
	} 

}
