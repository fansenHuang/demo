package com.activemq.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 * 
 * @author wendong
 *
 * 2019年3月1日
 */
@Service
public class Consumer2 {
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	
	@JmsListener(destination = "zh-topic")
	@SendTo("return-queue")
	public String receiveQueue(String text) {
		System.out.println("Consumer2收到:" + text);
		return "Consumer2收到!";
	}
}