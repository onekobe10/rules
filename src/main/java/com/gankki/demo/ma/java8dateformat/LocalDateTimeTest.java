package com.gankki.demo.ma.java8dateformat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/15
 */
public class LocalDateTimeTest {
	
	
	public static void main(String[] args){
		System.out.println("-----旧版的时刻表示Date---------");
		Date date = new Date();
	    System.out.println(date);

	    System.out.println("-------新版的时刻Instant--------");
		Instant instant = Instant.now();
	    System.out.println(instant);

	    System.out.println("-------新版的日期时间------");
		//LocalDateTime ldt = LocalDateTime.of(2017, 7, 11, 20, 45, 5);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfWeek().getValue());
		// LocalDateTime不能直接转为时刻Instant，转换需要一个参数ZoneOffset，ZoneOffset表示相对于格林尼治的时区差，北京是+08:00
		System.out.println(ldt.toInstant(ZoneOffset.of("+08:00")));
		System.out.println(ZoneId.of("GMT+08:00"));

		// LocalDateTime由两部分组成，一部分是日期LocalDate，另一部分是时间LocalTime

		//表示2017年7月11日
		LocalDate ld = LocalDate.of(2017, 7, 11);

		//当前时刻按系统默认时区解读的日期
		LocalDate now = LocalDate.now();

		//表示21点10分34秒
		LocalTime lt = LocalTime.of(21, 10, 34);

		//当前时刻按系统默认时区解读的时间
		LocalTime time = LocalTime.now();

		LocalDateTime ldt1 = LocalDateTime.of(2017, 7, 11, 20, 45, 5);
		LocalDate ld1 = ldt.toLocalDate(); //2017-07-11
		LocalTime lt1 = ldt.toLocalTime(); // 20:45:05

		//LocalDate加上时间，结果为2017-07-11 21:18:39
		LocalDateTime ldt2 = ld1.atTime(21, 18, 39);

		//LocalTime加上日期，结果为2016-03-24 20:45:05
		LocalDateTime ldt3 = lt1.atDate(LocalDate.of(2016, 3, 24));


		System.out.println(ZonedDateTime.now());
		ZonedDateTime ldt4 = ZonedDateTime.now();
		Instant now1 = ldt4.toInstant();

		// Java 8中，主要的格式化类是java.time.format.DateTimeFormatter，它是线程安全的

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt5 = LocalDateTime.of(2016,8,18,14,20,45);
		System.out.println(formatter.format(ldt5));

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String str = "2016-08-18 14:20:45";
		LocalDateTime ldt6 = LocalDateTime.parse(str, formatter);

		// 与Joda-Time一样，Java 8的大部分类都是不可变类，修改操作是通过创建并返回新对象来实现的，原对象本身不会变。

		// 调整时间为下午3点20
		LocalDateTime ldt7 = LocalDateTime.now();
		ldt7 = ldt7.withHour(15).withMinute(20).withSecond(0).withNano(0);

		LocalDateTime ldt8 = LocalDateTime.now();
		ldt8 = ldt8.toLocalDate().atTime(15, 20);

		LocalDateTime ldt9 = LocalDateTime.now();
		ldt9 = ldt9.plusHours(3).plusMinutes(5);


	}
}
