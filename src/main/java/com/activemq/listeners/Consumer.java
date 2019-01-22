package com.activemq.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
@Service
public class Consumer {
	/**
	 * 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	 * @param text
	 */
	@JmsListener(destination = "zh-queue")
	public void receiveQueue(String text) {
		System.out.println("Consumer收到:" + text);
	}
}
