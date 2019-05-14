package com.gankki.demo.concurrent.timetaskandschedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class TimerFixedDelay {
	static class LongRunningTask extends TimerTask {
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			System.out.println("long running finished");
		}
	}

	static class FixedDelayTask extends TimerTask {
		@Override
		public void run() {
			System.out.println(System.currentTimeMillis());
		}
	}

	/**
	 * 有两个定时任务，第一个运行一次，但耗时5秒，第二个是重复执行，1秒一次，第一个先运行。
	 * 运行该程序，会发现，第二个任务只有在第一个任务运行结束后才会开始运行，运行后1秒一次。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();

		timer.schedule(new LongRunningTask(), 3000);
		timer.schedule(new FixedDelayTask(), 100, 1000);
	}
}
