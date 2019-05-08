package com.gankki.demo.concurrent.sync;

public class StaticCounter {
	private static int count = 0;

	public static synchronized void incr() {
		count++;
	}

	/**
	 * 静态同步方法
	 * @return
	 */
	public static synchronized int getCount() {
		return count;
	}

	/**
	 * 静态同步代码块
	 * @return
	 */
	public static int getCount2() {
		synchronized(StaticCounter.class){
			return count;
		}
	}
}
