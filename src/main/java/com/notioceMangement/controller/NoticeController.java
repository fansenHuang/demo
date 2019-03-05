package com.notioceMangement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@RequestMapping("")
	public String notice(){
		
		return "notice/notice";
	}
	
}
