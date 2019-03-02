package com.websocket.WebSocketController;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.websocket.entity.WebSocketMessage;

@RestController
public class WebSocketController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@MessageMapping("/welcome") // 当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@ResponseMapping
	@SendTo("/topic/getResponse") // 当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
	public WebSocketMessage say(WebSocketMessage message) {
		logger.info("Web socket message is {}", message);
		try {
			// 睡眠1秒 
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new WebSocketMessage(message.getMessage(), LocalDateTime.now());
	}
}