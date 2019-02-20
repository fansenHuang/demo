package com.core.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBInfoUtils {

	public DBInfoUtils(String properties) {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(properties));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Properties props = new Properties();

	public String getValue(String key) {
		return props.getProperty(key);
	}

	public int getIntValue(String key) {
		return Integer.parseInt(props.getProperty(key));
	}

	public long getLongValue(String key) {
		return Long.parseLong(props.getProperty(key));
	}

	public boolean getBooleanValue(String key) {
		return Boolean.valueOf(props.getProperty(key));
	}
}
