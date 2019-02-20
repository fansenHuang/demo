package com.system.service;

import java.util.List;

import com.system.entity.Dept;

public interface DeptService {
	
	List<Dept> deptTree();

	int andDept(Dept dept);
	
}
