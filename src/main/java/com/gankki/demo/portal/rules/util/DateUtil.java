package com.gankki.demo.portal.rules.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	/**
	 * 获取上个月的
	 */
	public static String getLastDate(){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		String format = sdf.format(cal.getTime());
		return format;
	}    
}
