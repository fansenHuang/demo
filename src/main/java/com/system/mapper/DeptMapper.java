package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.system.entity.Dept;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
@Repository
public interface DeptMapper {
	
	List<Dept> deptTree();

	int saveDept(Dept dept);

	List<Dept> deptList(@Param("start")String start, @Param("end")String end, @Param("deptName")String deptName);

	void delAll(@Param("ids")String[] ids);

	Dept selectDeptById(@Param("id")Integer id);
}
