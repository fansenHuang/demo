package com.notice.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.notice.entity.Notice;
import com.notice.service.MyNoticeService;
import com.notice.service.NoticeService;

/**
 * 消息推送
 * 
 * @author wendong
 *
 *         2019年3月16日
 */
@Controller
@RequestMapping("/myNotice/")
public class MyNoticeController {

	@Resource
	private MyNoticeService myNoticeService;

	@Resource
	private NoticeService noticeService;

	/**
	 * 跳转到我的通知列表页面
	 * 
	 * @return
	 */
	@RequestMapping("myNoticeList")
	public String myNoticeList(Map<String, Object> map, String start, String end, String title, Integer status,
			String type, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		PageHelper.startPage(page, 8);
		List<Notice> myNoticeList = myNoticeService.myNoticeList(type, title, start, end, status);
		PageInfo<Notice> pageInfo = new PageInfo<Notice>(myNoticeList);

		map.put("pageInfo", pageInfo);

		map.put("start", start);
		map.put("end", end);
		map.put("title", title);
		map.put("status", status);

		return "notice/myNotice/myNoticeList";
	}

	/**
	 * 跳转到我的通知详情页面
	 * 
	 * @return
	 */
	@RequestMapping("myTopNotice")
	public String myTopNotice(Map<String, Object> map, Integer nid) {

		// 改为已读
		Integer status = myNoticeService.findUserNoticeById(nid.toString());
		if (status == null) {
			myNoticeService.insertUserNotice(nid);
		}
		Notice notice = noticeService.findNoticeById(nid.toString());
		map.put("notice", notice);
		return "notice/notification/topNotice";
	}

	/**
	 * 删除我的通知
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delMyNotice")
	public String delMyNotice(String data) {

		String[] ids = data.split(",");
		Integer status = myNoticeService.findUserNoticeById(ids[0]);

		myNoticeService.delMyNotice(ids, status);

		return "success";
	}

}
