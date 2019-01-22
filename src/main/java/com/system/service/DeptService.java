package com.system.service;

import java.util.List;

import com.system.entity.Dept;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
public interface DeptService {
	
	List<Dept> deptTree();

	int saveDept(Dept dept);

	List<Dept> deptList(String start, String end, String deptName);

	void delAll(String[] ids);

	Dept selectDeptById(Integer id);
	
}
