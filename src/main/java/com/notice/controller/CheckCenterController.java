package com.notice.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.websocket.server.ApiReturnObject;
import com.websocket.server.ApiReturnUtil;
import com.websocket.server.WebSocketServer;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {
	// 页面请求
	@GetMapping("/socket/{cid}")
	public ModelAndView socket(@PathVariable String cid) {
		ModelAndView mav = new ModelAndView("/notice/socket");
		mav.addObject("cid", cid);
		return mav;
	}

	// 送数据接口
	@ResponseBody
	@RequestMapping("/socket/push/{cid}")
	public ApiReturnObject pushToWeb(@PathVariable String cid, String message) {
		try {
			WebSocketServer.sendInfo(message, cid);
		} catch (IOException e) {
			e.printStackTrace();
			return ApiReturnUtil.error(cid + "#" + e.getMessage());
		}
		return ApiReturnUtil.success(cid);
	}
}