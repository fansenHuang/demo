package com.workPlatfrom.service;

import java.util.List;

import com.workPlatfrom.entity.Notice;

public interface NoticeManageService {

	List<Notice> selectNoticeAll();

	void andNotice(Notice notice);

	List<Notice> selectNoticeBySearch(String time, String content);

	void deleteNotice(Integer[] intArr);

	Notice selectNoticeByID(String iD);
	
}

