package com.workPlatfrom.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.workPlatfrom.entity.Notice;
import com.workPlatfrom.service.NoticeManageService;
/**
 * 公告管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/noticeManage/")
public class NoticeManageCotroller {

	@Autowired
	private NoticeManageService noticeManageService;

	// 公告列表
	@RequestMapping("selectNoticeAll")
	public String selectNoticegAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<Notice> noticeList = noticeManageService.selectNoticeAll();
		PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加公告
	@RequestMapping("andNotice")
	public String andWorkLog(Notice notice, String callback) throws IOException {

		noticeManageService.andNotice(notice);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 查找公告
	@RequestMapping("selectNoticeBySearch")
	public String selectNoticeBySearch(String callback, Integer page, String time,String content) {

		PageHelper.startPage(page, 10);

		List<Notice> noticeList = noticeManageService.selectNoticeBySearch(time, content);

		PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 删除公告
	@RequestMapping("deleteNotice")
	public String deleteNotice(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		noticeManageService.deleteNotice(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectNoticeByID")
	public String selectWorkLogByID(String callback, String ID) {

		Notice notice = noticeManageService.selectNoticeByID(ID);
		return callback + "(" + new Gson().toJson(notice) + ")";
	}

}