package com.gankki.demo.concurrent.timetaskandschedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class EndlessLoopTimer {
	static class LoopTask extends TimerTask {

		@Override
		public void run() {
			while (true) {
				try {
					// ... 执行任务
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 永远也没有机会执行
	 */
	static class ExampleTask extends TimerTask {
		@Override
		public void run() {

			System.out.println("hello");
		}
	}

	/**
	 * 第一个定时任务是一个无限循环，其后的定时任务ExampleTask将永远没有机会执行。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.schedule(new LoopTask(), 10);
		timer.schedule(new ExampleTask(), 100);
	}
}
