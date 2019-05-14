package com.gankki.demo.concurrent.timetaskandschedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class TimerFixedRate {

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

	static class FixedRateTask extends TimerTask {

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis());
		}
	}

	/**
	 * 运行该程序，第二个任务同样只有在第一个任务运行结束后才会运行，但它会把之前没有运行的次数补过来，一下子运行5次
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();

		timer.schedule(new LongRunningTask(), 10);
		timer.scheduleAtFixedRate(new FixedRateTask(), 100, 1000);
	}
}
