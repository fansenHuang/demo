package com.workPlatfrom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.workPlatfrom.entity.WorkLog;

@Repository
public interface LogManageMapper {

	//查询所有日志
	List<WorkLog> selectWorkLogAll(@Param("userId")Integer userid);

	//添加日志
	void andWorkLog(WorkLog workLog);

	//通过搜索查询
	List<WorkLog> selectWorkLogBySearch(@Param("time")String time, @Param("logType")String logType, @Param("submitState")Integer submitState);

	//删除
	void deleteWorkLog(@Param("ids")Integer[] intArr);

	//通过id查找
	WorkLog selectWorkLogByID(@Param("id")String id);

	//待审核
	List<WorkLog> selectToAuditWorkLogAll(@Param("userId")Integer id);

}
