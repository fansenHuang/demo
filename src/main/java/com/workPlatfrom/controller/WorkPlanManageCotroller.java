package com.workPlatfrom.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.workPlatfrom.entity.DepartmentalWorkPlan;
import com.workPlatfrom.entity.MyArrangedWork;
import com.workPlatfrom.entity.MyWorkPlan;
import com.workPlatfrom.entity.Notice;
import com.workPlatfrom.service.NoticeManageService;
import com.workPlatfrom.service.WorkPlanManageService;

/**
 * 工作计划 （我的工作计划 我安排的工作计划 部门工作计划 有关联？怎么关联？）
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/workPlanManage/")
public class WorkPlanManageCotroller {

	@Autowired
	private WorkPlanManageService workPlanManageService;

	// ----------------------------------------我的工作计划---------------------------------
	// 我的计划列表
	@RequestMapping("selectMyWorkPlanAll")
	public String selectMyWorkPlanAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<MyWorkPlan> MyWorkPlanList = workPlanManageService.selectMyWorkPlanAll();
		PageInfo<MyWorkPlan> pageInfo = new PageInfo<>(MyWorkPlanList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加我的计划
	@RequestMapping("andMyWorkPlan")
	public String andMyWorkPlan(MyWorkPlan myWorkPlan, String callback) throws IOException {

		workPlanManageService.andMyWorkPlan(myWorkPlan);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 查找我的计划
	@RequestMapping("selectMyWorkPlanBySearch")
	public String selectMyWorkPlanBySearch(@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "verifierId", required = false) Integer verifierId,
			@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "finishjob", required = false) Integer finishjob,
			@RequestParam(value = "name", required = false) String name) {

		PageHelper.startPage(page, 10);
		System.out.println("WorkPlanManageCotroller.selectMyWorkPlanBySearch()" + verifierId);
		List<MyWorkPlan> myWorkPlanList = workPlanManageService.selectMyWorkPlanBySearch(verifierId, startTime, endTime,
				finishjob, name);

		PageInfo<MyWorkPlan> pageInfo = new PageInfo<>(myWorkPlanList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 删除我的计划
	@RequestMapping("deleteMyWorkPlan")
	public String deleteMyWorkPlan(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		workPlanManageService.deleteMyWorkPlan(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectMyWorkPlanByID")
	public String selectMyWorkPlanByID(String callback, String ID) {

		MyWorkPlan myWorkPlan = workPlanManageService.selectMyWorkPlanByID(ID);
		return callback + "(" + new Gson().toJson(myWorkPlan) + ")";
	}

	// -----------------------------------------部门工作计划------------------------------------
	// 部门计划列表
	@RequestMapping("selectDepartmentalWorkPlanAll")
	public String selectDepartmentalWorkPlanAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<DepartmentalWorkPlan> departmentalWorkPlanList = workPlanManageService.selectDepartmentalWorkPlanAll();
		PageInfo<DepartmentalWorkPlan> pageInfo = new PageInfo<>(departmentalWorkPlanList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加我的计划
	@RequestMapping("andDepartmentalWorkPlan")
	public String andDepartmentalWorkPlan(DepartmentalWorkPlan departmentalWorkPlan, String callback)
			throws IOException {

		workPlanManageService.andDepartmentalWorkPlan(departmentalWorkPlan);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 查找我的计划
	@RequestMapping("selectDepartmentalWorkPlanBySearch")
	public String selectDepartmentalWorkPlanBySearch(
			@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "verifierId", required = false) Integer departmentalId,
			@RequestParam(value = "executorId", required = false) Integer executorId,
			@RequestParam(value = "verifierId", required = false) Integer verifierId,
			@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "finishjob", required = false) Integer finishjob,
			@RequestParam(value = "name", required = false) String name) {

		PageHelper.startPage(page, 10);
		List<DepartmentalWorkPlan> departmentalWorkPlanList = workPlanManageService.selectDepartmentalWorkPlanBySearch(
				departmentalId, executorId, verifierId, startTime, endTime, finishjob, name);

		PageInfo<DepartmentalWorkPlan> pageInfo = new PageInfo<>(departmentalWorkPlanList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 删除我的计划
	@RequestMapping("deleteDepartmentalWorkPlan")
	public String deleteDepartmentalWorkPlan(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		workPlanManageService.deleteDepartmentalWorkPlan(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectDepartmentalWorkPlanByID")
	public String selectDepartmentalWorkPlanByID(String callback, String ID) {

		DepartmentalWorkPlan departmentalWorkPlan = workPlanManageService.selectDepartmentalWorkPlanByID(ID);
		return callback + "(" + new Gson().toJson(departmentalWorkPlan) + ")";
	}

	// -----------------------------------------我安排的工作-----------------------------------
	// //查询所有我安排的工作计划
	@RequestMapping("selectMyArrangedWorkAll")
	public String selectMyArrangedWorkAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<MyArrangedWork> myArrangedWorkList = workPlanManageService.selectMyArrangedWorkAll();
		PageInfo<MyArrangedWork> pageInfo = new PageInfo<>(myArrangedWorkList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加我安排的计划
	@RequestMapping("andMyArrangedWork")
	public String andMyArrangedWork(MyArrangedWork myArrangedWork, String callback) throws IOException {

		workPlanManageService.andMyArrangedWork(myArrangedWork);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 通过条件搜索
	@RequestMapping("selectMyArrangedWorkBySearch")
	public String selectMyArrangedWorkBySearch(@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "executorId", required = false) Integer executorId,
			@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "finishjob", required = false) Integer finishjob,
			@RequestParam(value = "name", required = false) String name) {

		PageHelper.startPage(page, 10);
		List<MyArrangedWork> myArrangedWorkList = workPlanManageService.selectMyArrangedWorkBySearch(executorId,
				startTime, endTime, finishjob, name);

		PageInfo<MyArrangedWork> pageInfo = new PageInfo<>(myArrangedWorkList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 删除
	@RequestMapping("deleteMyArrangedWork")
	public String deleteMyArrangedWork(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		workPlanManageService.deleteMyArrangedWork(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectMyArrangedWorkByID")
	public String selectMyArrangedWorkByID(String callback, String ID) {

		MyArrangedWork myArrangedWork = workPlanManageService.selectMyArrangedWorkByID(ID);
		return callback + "(" + new Gson().toJson(myArrangedWork) + ")";
	}

}