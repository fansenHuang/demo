package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wendong
 *
 *         2019年2月22日
 */
@SpringBootApplication(scanBasePackages = { "com.*.controller", "com.system.shiro", "com.*.service.impl",
		"com.*.entity", "com.*.config", "com.activemq.listeners", "com.*.server" })
@MapperScan("com.*.mapper")
public class IcspApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcspApplication.class, args);
	}

}
