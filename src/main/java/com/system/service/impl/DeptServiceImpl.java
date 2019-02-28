package com.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.Dept;
import com.system.entity.User;
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
	public int saveDept(Dept dept) {
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		
		dept.setCreateBy(user.getUserName());
		dept.setCreateTime(new Date());
		return deptMapper.saveDept(dept);
	}

	@Override
	public List<Dept> deptList(String start, String end, String deptName) {
		
		return deptMapper.deptList(start,end,deptName);
	}

	@Override
	public void delAll(String[] ids) {
		
		deptMapper.delAll(ids);
	}

	@Override
	public Dept selectDeptById(Integer id) {
		
		return deptMapper.selectDeptById(id);
	}

}
