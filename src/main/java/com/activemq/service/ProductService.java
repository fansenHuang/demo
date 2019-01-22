package com.activemq.service;

import javax.jms.Destination;

/**
 * 
 * @author wendong
 *
 * 2019年1月22日
 */
public interface ProductService {
	
	/**
	 * 
	 * @param destination
	 * @param message
	 */
    void sendMessage(Destination destination,String message);
}
