package com.activemq.controller;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activemq.service.ProductService;

@RestController
@RequestMapping("/activeMq/")
public class ActiveMqController {
	
	@Autowired
	private Queue queue;
	@Autowired
	private Topic topic;
	@Autowired
	private ProductService productService;

	@RequestMapping("/queue/{msg}")
	public void sendQueue(@PathVariable("msg") String msg) {
		System.out.println("ActiveMqController.sendQueue()"+"信息");
		productService.sendMessage(this.queue, msg);
	}

	@RequestMapping("/topic/{msg}")
	public void sendTopic(@PathVariable("msg") String msg) {
		productService.sendMessage(this.topic, msg);
	}
}