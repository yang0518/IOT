package com.stylefeng.guns.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	
	
	public static void main(String[] args) {
		String ss = "2018-04-25 01:26:32.444+0000";
		System.out.println(getStrTimeForString(ss));
	}
	
	
	public static String getStrTimeForString(String strTime){
		String timeStr = null;
		if(strTime == null || "".equals(strTime))
			return timeStr;
		
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df.parse(strTime);
			timeStr = df.format(date);
		} catch (ParseException e) {
			timeStr = null;
			e.printStackTrace();
		}
		return timeStr;
	}

}
