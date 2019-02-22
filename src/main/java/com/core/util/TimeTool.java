package com.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author wendong
 *
 * 2019年2月22日
 */
public class TimeTool {
	
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}	
