package com.activemq.service.impl;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.activemq.service.ProductService;

/**
 * 1.第一个方法实现了接口，把接收到的消息和消息模式放到了队列里或者主题里就是queue或topic里，然后只要写消费者加上@JmsListener监听队列消息就可以自动获取
	2.这里的第二个方法加了监听注解就可以收到消费者反馈的信息，前提消费者要加@SendTo注解，具体看下面消费者类
 * @author wendong
 *
 * 2019年3月1日
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Override
	public void sendMessage(Destination destination, String message) {
		jmsMessagingTemplate.convertAndSend(destination, message);
	}

	@JmsListener(destination = "return-queue")
	public void Message(String message) {
		System.out.println("Product收到:" + message);
	}
}
