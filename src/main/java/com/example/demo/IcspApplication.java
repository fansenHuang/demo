 package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.*.controller","com.system.shiro","com.*.service.impl","com.*.entity","com.system.config"})
//@SpringBootApplication
@MapperScan("com.*.mapper")
//@ComponentScan({"com.*.controller","com.core.shiro","com.*.service.impl"})
//@ComponentScan("com.core.entity")
public class IcspApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcspApplication.class, args);
	}

}

