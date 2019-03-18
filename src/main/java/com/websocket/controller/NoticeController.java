package com.websocket.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.websocket.entity.Notice;
import com.websocket.server.WebSocketServer;
import com.websocket.service.NoticeService;

/**
 * 消息推送
 * 
 * @author wendong
 *
 *         2019年3月16日
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String notice() {
		
		
		return "notice/noticeList";
	}

	/**
	 * 跳转到新增页面
	 * 
	 * @return
	 */
	@RequestMapping("/addNotice")
	public String addNotice() {

		return "notice/addNotice";
	}

	/**
	 * 保存新增 if notice.getStatus = 1 发布 if notice.getStatus = 0 草稿箱
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@ResponseBody
	@RequestMapping("/saveNotice")
	public void saveNotice(Notice notice) throws IOException, InterruptedException {

		System.out.println("NoticeController.saveNotice()" + notice);

		Gson gson =  new Gson();
		WebSocketServer.sendInfo(gson.toJson(notice), null);

	}

}
