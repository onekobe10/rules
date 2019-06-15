package com.gankki.demo.test.datetimeformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/13
 */
public class KKTest {

	/**
	 * h am/pm 中的小时数（1-12）
	 * H 一天中的小时数（0-23）
	 * k 一天中的小时数（0-23）
	 * K am/pm 中的小时数（0-11）
	 *
	 */
	public static void main(String[] args){
		SimpleDateFormat broken = new SimpleDateFormat("kk:mm:ss");
		broken.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		SimpleDateFormat brokenKK = new SimpleDateFormat("KK:mm:ss");
		broken.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		SimpleDateFormat working = new SimpleDateFormat("HH:mm:ss");
		working.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		SimpleDateFormat workinghh = new SimpleDateFormat("hh:mm:ss");
		working.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

		Date epoch = new Date(0);

		System.out.println(broken.format(epoch));
		System.out.println(brokenKK.format(epoch));
		System.out.println(working.format(epoch));
		System.out.println(workinghh.format(epoch));
	}
}
