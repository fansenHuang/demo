package com.notice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.notice.entity.Notice;
import com.notice.service.NoticeService;
import com.system.entity.User;
import com.websocket.server.WebSocketServer;

/**
 * 消息推送
 * 
 * @author wendong
 *
 *         2019年3月16日
 */
@Controller
@RequestMapping("/notice/")
public class NoticeController {

	@Resource
	private NoticeService noticeService;

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping("noticeList")
	public String notice(Map<String, Object> map, String start, String end, String title, Integer status, String type,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		System.out.println("NoticeController.notice()" + type + "--" + start + "--" + end + "--" + title + "--" + status
				+ "--" + type);
		PageHelper.startPage(page, 8);
		List<Notice> noticeList = noticeService.noticeList(type, title, start, end, status);

		PageInfo<Notice> pageInfo = new PageInfo<Notice>(noticeList);

		map.put("pageInfo", pageInfo);

		map.put("start", start);
		map.put("end", end);
		map.put("title", title);
		map.put("status", status);

		return "notice/notification/noticeList";
	}

	/**
	 * 跳转到新增页面
	 * 
	 * @return
	 */
	@RequestMapping("/addNotice")
	public String addNotice() {

		return "notice/notification/addNotice";
	}

	/**
	 * 保存信息 if notice.getStatus = 1 发布 if notice.getStatus = 0 草稿箱
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@ResponseBody
	@RequestMapping("/saveNotice")
	public void saveNotice(Notice notice) throws IOException, InterruptedException {

		notice.setStatus(1);
		noticeService.saveNotice(notice);
		String message = notice.getID() + "-" + notice.getType() + "-" + notice.getContent();
		WebSocketServer.sendInfo(message, null);

	}

	/**
	 * 保存到草稿箱 if notice.getStatus = 1 发布 if notice.getStatus = 0 草稿箱
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@ResponseBody
	@RequestMapping("/saveDrafts")
	public void saveDrafts(Notice notice) throws IOException, InterruptedException {

		notice.setStatus(0);
		noticeService.saveNotice(notice);
	}

	/**
	 * 批量删除
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delAll")
	public String delAll(String data) {
		System.out.println("NoticeController.delAll()" + data);
		String[] ids = data.split(",");
		noticeService.delAll(ids);
		return "success";

	}

	/**
	 * 删除
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(String data) {
		String[] ids = data.split(",");
		noticeService.delAll(ids);
		return "success";

	}

	/**
	 * 草稿箱的信息发送出去 设置status=1
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("send")
	public String send(String id) {
		
		noticeService.updateStatusById(id);
		
		Notice notice = noticeService.findNoticeById(id);
		String message = notice.getID() + "-" + notice.getType() + "-" + notice.getContent();
		try {
			WebSocketServer.sendInfo(message, null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "success";

	}

}
