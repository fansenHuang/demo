package com.notice.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Service;

import com.notice.entity.Notice;
import com.notice.mapper.MyNoticeMapper;
import com.notice.mapper.NoticeMapper;
import com.notice.service.NoticeService;
import com.system.entity.User;

/**
 * 
 * @author wendong
 *
 *         2019年1月22日
 */
@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper noticeMapper;

	@Resource
	private MyNoticeMapper myNoticeMapper;

	/**
	 * 保存新增推送的消息
	 */
	@Override
	public int saveNotice(Notice notice) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		notice.setCreateBy(user.getUserName());
		notice.setCreateTime(new Date());
		return noticeMapper.saveNotice(notice);
	}

	/**
	 * 查询信息
	 */
	@Override
	public List<Notice> noticeList(String type, String title, String start, String end, Integer status) {

		return noticeMapper.noticeList(type, title, start, end, status);
	}

	@Override
	public void delAll(String[] ids) {

		noticeMapper.delAll(ids);
		myNoticeMapper.delAll(ids);
	}

	/**
	 * 草稿箱到发送
	 */
	@Override
	public void updateStatusById(String id) {

		noticeMapper.updateStatusById(id);
	}

	@Override
	public Notice findNoticeById(String id) {

		return noticeMapper.findNoticeById(id);
	}

}
