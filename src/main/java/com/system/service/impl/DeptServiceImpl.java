package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.Dept;
import com.system.mapper.DeptMapper;
import com.system.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> deptTree() {
		
		return  deptMapper.deptTree();
	}

	@Override
	public int andDept(Dept dept) {
		
		return deptMapper.andDept(dept);
	}

	@Override
	public List<Dept> deptList(String start, String end, String deptName) {
		
		return deptMapper.deptList(start,end,deptName);
	}

}
