package com.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@RequestMapping("")
	public String notice(){
		
		return "notice/noticeList";
	}
	
	@RequestMapping("addNotice")
	public String addNotice(){
		
		return "notice/addNotice";
	}
	
}
