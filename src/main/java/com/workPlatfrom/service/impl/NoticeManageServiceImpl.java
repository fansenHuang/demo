package com.workPlatfrom.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.User;
import com.workPlatfrom.entity.Notice;
import com.workPlatfrom.mapper.NoticeManageMapper;
import com.workPlatfrom.service.NoticeManageService;

@Service
public class NoticeManageServiceImpl implements NoticeManageService{

	@Autowired
	private NoticeManageMapper noticeManageMapper;

	//公告列表
	@Override
	public List<Notice> selectNoticeAll() {
		
		return noticeManageMapper.selectNoticeAll();
	}

	//添加公告
	@Override
	public void andNotice(Notice notice) {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
//		notice.setCreateBy(user.getUsername());
		notice.setCreateTime(new Date());
		noticeManageMapper.andNotice(notice);
		
	}

	//搜索公告
	@Override
	public List<Notice> selectNoticeBySearch(String time, String content) {
		
		return noticeManageMapper.selectNoticeBySearch(time,content);
	}

	//删除公告
	@Override
	public void deleteNotice(Integer[] intArr) {
		
		noticeManageMapper.deleteNotice(intArr);
		
	}

	//根据ID查找
	@Override
	public Notice selectNoticeByID(String iD) {
		
		return noticeManageMapper.selectNoticeByID(iD);
		
	}
	
}
