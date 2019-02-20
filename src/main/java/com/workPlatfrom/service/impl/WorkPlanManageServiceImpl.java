package com.workPlatfrom.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.protocol.Security;
import com.system.entity.User;
import com.workPlatfrom.entity.DepartmentalWorkPlan;
import com.workPlatfrom.entity.MyArrangedWork;
import com.workPlatfrom.entity.MyWorkPlan;
import com.workPlatfrom.entity.Notice;
import com.workPlatfrom.mapper.NoticeManageMapper;
import com.workPlatfrom.mapper.WorkPlanManageMapper;
import com.workPlatfrom.service.NoticeManageService;
import com.workPlatfrom.service.WorkPlanManageService;

@Service
public class WorkPlanManageServiceImpl implements WorkPlanManageService {

	@Autowired
	private WorkPlanManageMapper workPlanManageMapper;

	// 查询我的工作计划列表
	@Override
	public List<MyWorkPlan> selectMyWorkPlanAll() {

		// User user = (User)SecurityUtils.getSubject().getPrincipal();

		// return workPlanManageMapper.selectMyWorkPlanAll(user.getID());
		return workPlanManageMapper.selectMyWorkPlanAll(1);
	}

	// 添加工作计划
	@Override
	public void andMyWorkPlan(MyWorkPlan myWorkPlan) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// myWorkPlan.setCreateBy(user.getUsername());
		myWorkPlan.setCreateTime(new Date());
		// myWorkPlan.setUserId(user.getID());
		workPlanManageMapper.andMyWorkPlan(myWorkPlan);

	}

	//
	@Override
	public List<MyWorkPlan> selectMyWorkPlanBySearch(Integer verifierId, String startTime, String endTime,
			Integer finishjob, String name) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		// return
		// workPlanManageMapper.selectMyWorkPlanBySearch(verifierId,startTime,endTime,finishjob,name,user.getID());
		return workPlanManageMapper.selectMyWorkPlanBySearch(verifierId, startTime, endTime, finishjob, name, 1);
	}

	@Override
	public void deleteMyWorkPlan(Integer[] intArr) {

		workPlanManageMapper.deleteMyWorkPlan(intArr);

	}

	@Override
	public MyWorkPlan selectMyWorkPlanByID(String iD) {

		return workPlanManageMapper.selectMyWorkPlanByID(iD);
	}

	// ----------------------------部门工作计划------------------------
	// 查询部门工作计划
	@Override
	public List<DepartmentalWorkPlan> selectDepartmentalWorkPlanAll() {

		// 查询员工的部门
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		int departmentId = 1;
		return workPlanManageMapper.selectDepartmentalWorkPlanAll();
	}

	// 添加部门工作计划
	@Override
	public void andDepartmentalWorkPlan(DepartmentalWorkPlan departmentalWorkPlan) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// departmentalWorkPlan.setCreateBy(user.getUsername());
		departmentalWorkPlan.setCreateTime(new Date());
		workPlanManageMapper.andDepartmentalWorkPlan(departmentalWorkPlan);

	}

	// 搜索部门工作计划
	@Override
	public List<DepartmentalWorkPlan> selectDepartmentalWorkPlanBySearch(Integer departmentalId, Integer executorId,
			Integer verifierId, String startTime, String endTime, Integer finishjob, String name) {

		return workPlanManageMapper.selectDepartmentalWorkPlanBySearch(departmentalId, executorId, verifierId,
				startTime, endTime, finishjob, name);
	}

	@Override
	public void deleteDepartmentalWorkPlan(Integer[] intArr) {

		workPlanManageMapper.deleteDepartmentalWorkPlan(intArr);

	}

	@Override
	public DepartmentalWorkPlan selectDepartmentalWorkPlanByID(String iD) {

		return workPlanManageMapper.selectDepartmentalWorkPlanByID(iD);
	}

	// ------------------------------------我安排的工作-----------------------------------

	// 查询所有
	@Override
	public List<MyArrangedWork> selectMyArrangedWorkAll() {
		User user = (User) SecurityUtils.getSubject().getPrincipal();

//		return workPlanManageMapper.selectMyArrangedWorkAll(user.getID());
		Integer suerId = 1;
		return workPlanManageMapper.selectMyArrangedWorkAll(suerId);
	}

	// 添加我安排的计划
	@Override
	public void andMyArrangedWork(MyArrangedWork myArrangedWork) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
//		myArrangedWork.setUserId(user.getID());
		myArrangedWork.setUserId(1);
		workPlanManageMapper.andMyArrangedWork(myArrangedWork);

	}

	// 通过条件搜索
	@Override
	public List<MyArrangedWork> selectMyArrangedWorkBySearch(Integer executorId,
			String startTime, String endTime, Integer finishjob, String name) {

		return workPlanManageMapper.selectMyArrangedWorkBySearch(executorId,startTime,
				endTime, finishjob, name);
	}

	// 删除
	@Override
	public void deleteMyArrangedWork(Integer[] intArr) {

		workPlanManageMapper.deleteMyArrangedWork(intArr);
	}

	// 根据Id搜索
	@Override
	public MyArrangedWork selectMyArrangedWorkByID(String iD) {
		return workPlanManageMapper.selectMyArrangedWorkByID(iD);
	}

}
