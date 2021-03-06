package com.gankki.demo.concurrent.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class ThreadLocalDateFormat {
	static ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static String date2String(Date date) {
		return sdf.get().format(date);
	}

	public static Date string2Date(String str) throws ParseException {
		return sdf.get().parse(str);
	}
}
