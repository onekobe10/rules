package com.gankki.demo.concurrent.timetaskandschedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class BasicTimer {

	static class DelayTask extends TimerTask {

		@Override
		public void run() {
			System.out.println("delayed task");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.schedule(new DelayTask(), 1600);
		//timer.scheduleAtFixedRate(new DelayTask(), new Date(), 1600);
		Thread.sleep(1000);
		System.out.println("主线程");
		Thread.sleep(800);
		timer.cancel();
	}
}
