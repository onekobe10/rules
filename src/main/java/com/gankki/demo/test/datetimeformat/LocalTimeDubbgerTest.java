package com.gankki.demo.test.datetimeformat;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
public class LocalTimeDubbgerTest {

	public static void main(String[] args){

		//System.out.println(LocalTime.parse("00:01:01", DateTimeFormatter.ofPattern("HH:mm:ss")).format(DateTimeFormatter.ofPattern("kk:mm:ss")));

		// 格式化时间时可以使用十二进制，因为此时时间是明确的
		System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));

		// 解析十二进制的时间时必须明确上下午，如果没有明确，则Java 8中的新的日期API LocalTime 不能解析时间 要求更严格了
		// 十二进制的时间格式字符号串解析如果没有明确上下午，会被认为是not a complete date/time
		// The value is validated in strict and smart mode but not in lenient mode.
		System.out.println(LocalTime.parse("12:01:01", DateTimeFormatter.ofPattern("hh:mm:ss")));

	}
}
