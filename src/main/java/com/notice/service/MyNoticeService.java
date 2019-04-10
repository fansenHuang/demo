package com.notice.service;

import java.util.List;

import com.notice.entity.Notice;

/**
 * 
 * @author wendong
 *
 *         2019年1月22日
 */
public interface MyNoticeService {

	/**
	 * 我的通知
	 * 
	 * @param type
	 *            类型
	 * @param title
	 *            标题
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @param status
	 *            是否阅读
	 * @return
	 */
	List<Notice> myNoticeList(String type, String title, String start, String end, Integer status);

	/**
	 * 改为已读
	 * 
	 * @param id
	 */
	void insertUserNotice(Integer id);

	/**
	 * 删除我的通知
	 * 
	 * @param ids
	 */
	void updateMyNoticeStatus(String[] ids);

	/**
	 * 查询是否存在
	 * 
	 * @param string
	 */
	Integer findUserNoticeById(String id);

	void delMyNotice(String[] id, Integer status);

}
