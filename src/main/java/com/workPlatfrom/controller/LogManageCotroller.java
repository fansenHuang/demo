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
import com.workPlatfrom.entity.WorkLog;
import com.workPlatfrom.service.LogManageService;

/**
 * 日志管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/logManage/")
public class LogManageCotroller {

	@Autowired
	private LogManageService logManageService;

	// 工作日志列表
	@RequestMapping("selectWorkLogAll")
	public String selectWorkLogAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<WorkLog> WorkLogList = logManageService.selectWorkLogAll();
		PageInfo<WorkLog> pageInfo = new PageInfo<>(WorkLogList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加日志
	@RequestMapping("andWorkLog")
	public String andWorkLog(WorkLog workLog, String callback) throws IOException {

		logManageService.andWorkLog(workLog);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 查找日志
	@RequestMapping("selectWorkLogBySearch")
	public String selectWorkLogBySearch(String callback, Integer page, String time, String logType,
			Integer submitState) {

		PageHelper.startPage(page, 10);

		List<WorkLog> workLogList = logManageService.selectWorkLogBySearch(time, logType, submitState);

		PageInfo<WorkLog> pageInfo = new PageInfo<>(workLogList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 删除日志
	@RequestMapping("deleteWorkLog")
	public String deleteWorkLog(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		logManageService.deleteWorkLog(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectWorkLogByID")
	public String selectWorkLogByID(String callback, String ID) {

		WorkLog workLog = logManageService.selectWorkLogByID(ID);
		return callback + "(" + new Gson().toJson(workLog) + ")";
	}

	// 待审核
	@RequestMapping("selectToAuditWorkLogAll")
	public String selectToAuditWorkLogAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<WorkLog> WorkLogList = logManageService.selectToAuditWorkLogAll();
		PageInfo<WorkLog> pageInfo = new PageInfo<>(WorkLogList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

}
