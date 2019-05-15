package com.gankki.demo.concurrent.synctool;

import java.util.concurrent.CountDownLatch;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class RacerWithCountDownLatch {
	static class Racer extends Thread {
		CountDownLatch latch;

		public Racer(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				this.latch.await();
				System.out.println(getName()
						+ " start run "+System.currentTimeMillis());
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * 在同时开始场景中，运行员线程等待主裁判线程发出开始指令的信号，一旦发出后，所有运动员线程同时开始，
	 * 计数初始为1，运动员线程调用await，主线程调用countDown
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int num = 10;
		CountDownLatch latch = new CountDownLatch(1);
		Thread[] racers = new Thread[num];
		for (int i = 0; i < num; i++) {
			racers[i] = new Racer(latch);
			racers[i].start();
		}
		Thread.sleep(1000);
		latch.countDown();
	}
}
