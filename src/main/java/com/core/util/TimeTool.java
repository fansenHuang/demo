package com.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
	
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}	
