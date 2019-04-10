package com.notice.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.notice.entity.Notice;
import com.notice.mapper.MyNoticeMapper;
import com.notice.mapper.NoticeMapper;
import com.notice.service.MyNoticeService;
import com.notice.service.NoticeService;
import com.system.entity.User;

/**
 * 
 * @author wendong
 *
 *         2019年1月22日
 */
@Service
public class MyNoticeServiceImpl implements MyNoticeService {

	@Resource
	private MyNoticeMapper myNoticeMapper;

	/**
	 * 我的通知
	 */
	@Override
	public List<Notice> myNoticeList(String type, String title, String start, String end, Integer status) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		return myNoticeMapper.myNoticeList(type, title, start, end, status, user.getID());
	}

	/**
	 * 改为已读
	 */
	@Override
	public void insertUserNotice(Integer nid) {

		myNoticeMapper.insertUserNotice(nid, ((User) SecurityUtils.getSubject().getPrincipal()).getID(), 1);
	}

	@Override
	public void updateMyNoticeStatus(String[] ids) {

		myNoticeMapper.updateMyNoticeStatus(ids);
	}

	@Override
	public Integer findUserNoticeById(String id) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		return myNoticeMapper.findUserNoticeById(id, user.getID().toString());
	}

	@Override
	public void delMyNotice(String[] ids, Integer status) {

		if (status == null) {
			myNoticeMapper.insertUserNotice(Integer.parseInt(ids[0]),
					((User) SecurityUtils.getSubject().getPrincipal()).getID(), 2);
		} else if (status == 1) {
			myNoticeMapper.updateMyNoticeStatus(ids);
		}
	}

}
