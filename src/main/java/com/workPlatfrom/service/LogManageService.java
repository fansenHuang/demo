package com.workPlatfrom.service;

import java.util.List;

import com.workPlatfrom.entity.WorkLog;

public interface LogManageService {

	List<WorkLog> selectWorkLogAll();

	void andWorkLog(WorkLog workLog);

	List<WorkLog> selectWorkLogBySearch(String time, String logType, Integer submitState);

	void deleteWorkLog(Integer[] intArr);

	WorkLog selectWorkLogByID(String iD);

	List<WorkLog> selectToAuditWorkLogAll();
	
}

