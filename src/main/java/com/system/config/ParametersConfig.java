package com.system.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author wendong
 *
 * 2019年2月22日
 */
@Component
@ConfigurationProperties(prefix = "config")
@PropertySource("classpath:application-dev.properties")
public class ParametersConfig {

	String uploadFile;

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
	
	
}
