package com.workPlatfrom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.workPlatfrom.entity.Notice;

@Repository
public interface NoticeManageMapper {

	List<Notice> selectNoticeAll();

	void andNotice(Notice notice);

	List<Notice> selectNoticeBySearch(@Param("time")String time,@Param("content")String content);

	void deleteNotice(@Param("ids")Integer[] ids);

	Notice selectNoticeByID(@Param("id")String id);
	
}
