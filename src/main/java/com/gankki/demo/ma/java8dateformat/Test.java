package com.gankki.demo.ma.java8dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/15
 */
public class Test {

	/**
	 * GMT Greenwich Mean Time 格林尼治时间
	 *
	 * 中国 东八区 GMT+08:00
	 * @param args
	 */
	public static void main(String[] args){
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz.getID());

		System.out.println(System.getProperty("user.timezone"));

		TimeZone tz1 = TimeZone.getTimeZone("GMT+08:00");
		System.out.println(tz1.getID());

		System.out.println("-------------------------------------");

		Locale locale = Locale.getDefault();
		System.out.println(locale.toString());

		System.out.println("-------------------------------------");


		Calendar calendar = Calendar.getInstance();
		System.out.println("year: "+calendar.get(Calendar.YEAR));
		System.out.println("month: "+calendar.get(Calendar.MONTH));
		System.out.println("day: "+calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("hour: "+calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("minute: "+calendar.get(Calendar.MINUTE));
		System.out.println("second: "+calendar.get(Calendar.SECOND));
		System.out.println("millisecond: " +calendar.get(Calendar.MILLISECOND));
		System.out.println("day_of_week: " + calendar.get(Calendar.DAY_OF_WEEK));

		System.out.println("------------------------------");

		Calendar calendar1 = Calendar.getInstance();
		//2016-08-15 14:15:20
		calendar.set(2016, 07, 15, 14, 15, 20);
		System.out.println(DateFormat.getDateTimeInstance()
				.format(calendar1.getTime()));
		System.out.println(DateFormat.getDateInstance()
				.format(calendar1.getTime()));
		System.out.println(DateFormat.getTimeInstance()
				.format(calendar1.getTime()));

		System.out.println("------------------------------");

		Calendar calendar2 = Calendar.getInstance();
 		//2016-08-15 14:15:20
		calendar2.set(2016, 07, 15, 14, 15, 20);
		System.out.println(DateFormat.getDateTimeInstance(
				DateFormat.LONG,DateFormat.LONG,Locale.CHINESE)
				.format(calendar2.getTime()));

		Calendar calendar3 = Calendar.getInstance();
		//2016-08-15 14:15:20
		calendar3.set(2016, 07, 15, 14, 15, 20);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a E");
		System.out.println(sdf.format(calendar3.getTime()));
	}

}
