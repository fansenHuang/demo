package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wendong
 *
 *         2019年2月22日
 */
@SpringBootApplication(scanBasePackages = { "com.*.config","com.*.controller", "com.system.shiro", "com.*.service.impl",
		"com.*.entity", "com.activemq.listeners", "com.*.server","com.*.filter"})
@MapperScan("com.*.mapper")
@ServletComponentScan(basePackages={"com.druid.servlet"})
public class IcspApplication {
	public static void main(String[] args) {
		SpringApplication.run(IcspApplication.class, args);
	}
}
