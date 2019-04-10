package com.notice.service;

import java.util.List;

import com.notice.entity.Notice;

/**
 * 
 * @author wendong
 *
 *         2019年1月22日
 */
public interface NoticeService {

	int saveNotice(Notice notice);

	List<Notice> noticeList(String type, String title, String start, String end, Integer status);

	void delAll(String[] ids);

	void updateStatusById(String id);

	Notice findNoticeById(String id);

}
