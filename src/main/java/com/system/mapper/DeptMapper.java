package com.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.system.entity.Dept;

@Repository
public interface DeptMapper {
	
	List<Dept> deptTree();

	int andDept(Dept dept);
}
