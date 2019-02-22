package com.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.entity.Dept;
import com.system.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>部门相关操作接口定义类</p>
 *
 * @author liwei
 **/
@Controller
@RequestMapping("/deptManage/")
@Api(description = "部门相关操作接口定义类")
public class DeptController{

	@Autowired
	private DeptService deptService;

	@ResponseBody
    @RequestMapping("deptTree")
	@ApiOperation(value = "展示deptZtree")
	public String selectDeptTree() throws JsonProcessingException{
    	List<Dept> deptList = deptService.deptTree();
    	ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(deptList);
		return zTreeJSON;
	}
	
	@ResponseBody
	@RequestMapping("andNode")
	@ApiOperation(value = "")
	public String andNode(String node,Integer parentId) throws JsonProcessingException{
		Dept dept = new Dept();
		dept.setName(node);
		dept.setPId(parentId);
		deptService.andDept(dept);
		List<Dept> list =  new ArrayList<>();
		list.add(dept);
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(list);
		return zTreeJSON;
	} 
}
