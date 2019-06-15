package com.gankki.demo.test.datetimeformat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *@desc Java 8 时间类型工具类
 *@author liuhao
 *@createDate 2019/6/13
 */
public class LocalDateTimeTest {

	/**
	 * Java8的DateTimeFormatter是线程安全的，而SimpleDateFormat并不是线程安全。
	 * @param args
	 */
	public static void main(String[] args){
		// ZoneId 时区
		System.out.println(ZoneId.systemDefault());

		System.out.println("-----------------------");

		// 当前日期
		System.out.println(LocalDate.now());
		// 当前时间
		System.out.println(LocalTime.now());
		// 当前日期和时间和组合
		System.out.println(LocalDateTime.now());

		System.out.println("--------------------------");

		System.out.println(LocalDate.parse("2017-02-12"));
		System.out.println(LocalTime.parse("12:23:52"));

		System.out.println(LocalDateTime.parse("2017-02-12T12:23:52"));
		System.out.println(LocalDateTime.parse("2017-02-12T14:23:52"));


		System.out.println("-----------------------HH&hh-------------------");
		System.out.println(LocalDateTime.parse("2017-02-12 06:23:52", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println(LocalDateTime.parse("2017-02-13 16:23:52", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println(LocalDateTime.parse("2017-02-14 06:23:52 上午", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-15 06:23:52 下午", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-14 00:23:52 上午", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-15 11:23:52 下午", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a")));

		/**
		 * h am/pm 中的小时数（0-11）
		 * H 一天中的小时数（0-23）
		 * k 一天中的小时数（0-23）
		 * K am/pm 中的小时数（0-11）
		 *
		 */
		System.out.println("-----------------------kk&KK--------------------");
		System.out.println(LocalDateTime.parse("2017-02-16 00:23:52 上午", DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-17 11:23:52 下午", DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-16 06:23:52 上午", DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-17 06:23:52 下午", DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-17 06:23:52 下午", DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a")));
		System.out.println(LocalDateTime.parse("2017-02-18 00:23:52", DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss")));
		System.out.println(LocalDateTime.parse("2017-02-19 24:23:53", DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss", Locale.ITALIAN)));
		System.out.println(LocalDateTime.parse("2017-02-19 00:23:52", DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss")));
		System.out.println(LocalDateTime.parse("2017-02-19 24:23:52", DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss")));

		System.out.println("--------------------------");

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS a")));
		System.out.println(LocalDateTime.parse("2019-06-13 06:40:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		System.out.println("--------------------------");

		System.out.println(LocalTime.parse("06:01:01 下午", DateTimeFormatter.ofPattern("hh:mm:ss a")));

		System.out.println("--------------------------");

		System.out.println(LocalTime.parse("00:01:01", DateTimeFormatter.ofPattern("HH:mm:ss")).format(DateTimeFormatter.ofPattern("kk:mm:ss")));

		System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("kk:mm:ss")));
	}
}
