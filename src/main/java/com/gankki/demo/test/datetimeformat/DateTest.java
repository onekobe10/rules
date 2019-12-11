package com.gankki.demo.test.datetimeformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

		Map<String, Object> map = new HashMap<>();
		map.put("test", LocalDateTime.now());
		// System.out.println(JSONObject.toJSONString(map));
		System.out.println("***************");
		System.out.println(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		System.out.println(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
	}
}
