package com.workPlatfrom.service;

import java.util.List;

import com.workPlatfrom.entity.DepartmentalWorkPlan;
import com.workPlatfrom.entity.MyArrangedWork;
import com.workPlatfrom.entity.MyWorkPlan;

public interface WorkPlanManageService {

	List<MyWorkPlan> selectMyWorkPlanAll();

	void andMyWorkPlan(MyWorkPlan myWorkPlan);

	List<MyWorkPlan> selectMyWorkPlanBySearch(Integer verifierId, String startTime, String endTime, Integer finishjob,
			String name);

	void deleteMyWorkPlan(Integer[] intArr);

	MyWorkPlan selectMyWorkPlanByID(String iD);

	// -----------------------------部门工作计划---------------------
	List<DepartmentalWorkPlan> selectDepartmentalWorkPlanAll();

	void andDepartmentalWorkPlan(DepartmentalWorkPlan departmentalWorkPlan);

	List<DepartmentalWorkPlan> selectDepartmentalWorkPlanBySearch(Integer departmentalId, Integer executorId,
			Integer verifierId, String startTime, String endTime, Integer finishjob, String name);

	void deleteDepartmentalWorkPlan(Integer[] intArr);

	DepartmentalWorkPlan selectDepartmentalWorkPlanByID(String iD);

	// ----------------------------我安排的工作----------------------

	List<MyArrangedWork> selectMyArrangedWorkAll();

	void andMyArrangedWork(MyArrangedWork myArrangedWork);

	List<MyArrangedWork> selectMyArrangedWorkBySearch(Integer executorId,
			String startTime, String endTime, Integer finishjob, String name);

	void deleteMyArrangedWork(Integer[] intArr);

	MyArrangedWork selectMyArrangedWorkByID(String iD);

}
