package com.gankki.demo.test.datetimeformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/13
 */
public class DateTest {


	public static void main(String[] args){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println(dateFormat.format(new Date()));

		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa", Locale.CHINESE);
		String LgTime = sdformat.format(date);
		System.out.println(LgTime);
	}
}
