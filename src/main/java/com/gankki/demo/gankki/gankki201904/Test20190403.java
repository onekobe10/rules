package com.gankki.demo.gankki.gankki201904;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/3
 */
public class Test20190403 {
	
	public static void main(String[] args){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calBegin = Calendar.getInstance(); //获取日历实例
		Calendar calEnd = Calendar.getInstance();
		System.out.println(Calendar.getInstance().get(Calendar.YEAR) - 2017);
		System.out.println(dateFormat.format(getYearLast(2017)));


		Calendar calendar = Calendar.getInstance();
		calendar.roll(Calendar.YEAR, -2);
		System.out.println(dateFormat.format(calendar.getTime()));

		System.out.println(1 % 4);

		StringBuilder sb = new StringBuilder("111");

	}

	/**
	 * 获取某年最后一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

}
