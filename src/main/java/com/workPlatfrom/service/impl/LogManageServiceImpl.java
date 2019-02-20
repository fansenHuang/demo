package com.workPlatfrom.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.User;
import com.workPlatfrom.entity.WorkLog;
import com.workPlatfrom.mapper.LogManageMapper;
import com.workPlatfrom.service.LogManageService;

@Service
public class LogManageServiceImpl implements LogManageService{

	@Autowired
	private LogManageMapper logManageMapper;
	
	//查询所有日志
	@Override
	public List<WorkLog> selectWorkLogAll() {
		
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		return logManageMapper.selectWorkLogAll(user.getID());
	}

	//添加日志
	@Override
	public void andWorkLog(WorkLog workLog) {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();

		// workLog.setCreateBy(user.getUsername());
//		workLog.setUserid(user.getID());
		workLog.setCreateTime(new Date());
		logManageMapper.andWorkLog(workLog);
		
	}

	//通过搜索查询
	@Override
	public List<WorkLog> selectWorkLogBySearch(String time, String logtype, Integer submitState) {
		
		return logManageMapper.selectWorkLogBySearch(time, logtype, submitState);
		
	}

	//删除
	@Override
	public void deleteWorkLog(Integer[] intArr) {
		
		logManageMapper.deleteWorkLog(intArr);
		
	}

	//通过id查找
	@Override
	public WorkLog selectWorkLogByID(String iD) {
		
		return logManageMapper.selectWorkLogByID(iD);
		
	}

	//待审核
	@Override
	public List<WorkLog> selectToAuditWorkLogAll() {
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		return logManageMapper.selectToAuditWorkLogAll(user.getID());
	}

}
