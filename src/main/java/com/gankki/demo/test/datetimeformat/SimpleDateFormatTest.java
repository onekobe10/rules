package com.gankki.demo.test.datetimeformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/15
 */
public class SimpleDateFormatTest {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

	public static void main(String[] args){
		for (int i = 0; i < 1 ; ++i) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						synchronized (sdf) {
							System.out.println(sdf.parse("2018-07-12 00:18:00"));
							System.out.println(sdf2.format(sdf.parse("2018-07-12 01:18:00")));
						}
						} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();//(4)启动线程
		}
	}

}
