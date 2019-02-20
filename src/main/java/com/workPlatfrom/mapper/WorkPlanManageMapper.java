package com.workPlatfrom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.workPlatfrom.entity.DepartmentalWorkPlan;
import com.workPlatfrom.entity.MyArrangedWork;
import com.workPlatfrom.entity.MyWorkPlan;
import com.workPlatfrom.entity.Notice;

@Repository
public interface WorkPlanManageMapper {

	List<MyWorkPlan> selectMyWorkPlanAll(@Param("id") Integer id);

	void andMyWorkPlan(MyWorkPlan myWorkPlan);

	List<MyWorkPlan> selectMyWorkPlanBySearch(@Param("verifierId") Integer verifierId,
			@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("finishjob") Integer finishjob, @Param("name") String name, @Param("userId") Integer id);

	void deleteMyWorkPlan(@Param("ids") Integer[] intArr);

	MyWorkPlan selectMyWorkPlanByID(@Param("id") String id);

	// -----------------------------部门工作计划---------------------------------
	// 查询部门工作计划
	List<DepartmentalWorkPlan> selectDepartmentalWorkPlanAll();

	// 添加部门工作计划
	void andDepartmentalWorkPlan(DepartmentalWorkPlan departmentalWorkPlan);

	// 根据条件查询部门工作计划
	List<DepartmentalWorkPlan> selectDepartmentalWorkPlanBySearch(@Param("departmentalId") Integer departmentalId,
			@Param("executorId") Integer executorId, @Param("verifierId") Integer verifierId,
			@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("finishjob") Integer finishjob, @Param("name") String name);

	// 删除部门计划
	void deleteDepartmentalWorkPlan(@Param("ids") Integer[] intArr);

	// 根据ID查询
	DepartmentalWorkPlan selectDepartmentalWorkPlanByID(@Param("id") String iD);

	// ----------------------------------------------我安排的工作计划-------------------------------

	// 查询所有
	List<MyArrangedWork> selectMyArrangedWorkAll(@Param("userId") Integer id);

	// 添加我安排的计划
	void andMyArrangedWork(MyArrangedWork myArrangedWork);

	// 通过条件搜索
	List<MyArrangedWork> selectMyArrangedWorkBySearch(@Param("executorId")Integer executorId,
			@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("finishjob")Integer finishjob, @Param("name")String name);

	// 删除
	void deleteMyArrangedWork(@Param("ids")Integer[] intArr);

	// 根据Id搜索
	MyArrangedWork selectMyArrangedWorkByID(@Param("id")String iD);

}
