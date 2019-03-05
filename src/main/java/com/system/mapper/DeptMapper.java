package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.Dept;

@Repository
public interface DeptMapper {
	
	List<Dept> deptTree();

	int andDept(Dept dept);

	List<Dept> deptList(@Param("start")String start, @Param("end")String end, @Param("deptName")String deptName);
}
