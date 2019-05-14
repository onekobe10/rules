package com.gankki.demo.concurrent.timetaskandschedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class ScheduledException {
	static class TaskA implements Runnable {

		@Override
		public void run() {
			System.out.println("task A");
		}
	}

	static class TaskB implements Runnable {

		@Override
		public void run() {
			System.out.println("task B");
			throw new RuntimeException();
		}
	}

	/**
	 * 与Timer不同，单个定时任务的异常不会再导致整个定时任务被取消了，即使背后只有一个线程执行任务
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService timer = Executors
				.newSingleThreadScheduledExecutor();
		timer.scheduleWithFixedDelay(new TaskA(), 0, 1, TimeUnit.SECONDS);
		timer.scheduleWithFixedDelay(new TaskB(), 2, 1, TimeUnit.SECONDS);
	}
}
