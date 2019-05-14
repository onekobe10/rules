package com.gankki.demo.concurrent.timetaskandschedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class TimerException {

	static class TaskA extends TimerTask {

		@Override
		public void run() {
			System.out.println("task A");
		}
	}

	static class TaskB extends TimerTask {

		@Override
		public void run() {
			System.out.println("task B");
			throw new RuntimeException();
		}
	}

	/**
	 * 如果希望各个定时任务不互相干扰，一定要在run方法内捕获所有异常。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.schedule(new TaskA(), 1, 1000);
		timer.schedule(new TaskB(), 2000, 1000);
	}
}
