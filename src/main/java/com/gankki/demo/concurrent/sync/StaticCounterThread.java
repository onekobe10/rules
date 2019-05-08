package com.gankki.demo.concurrent.sync;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/8
 */
public class StaticCounterThread extends Thread {
	StaticCounter counter;

	public StaticCounterThread(StaticCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 10));
		} catch (InterruptedException e) {
		}
		StaticCounter.incr();
	}

	public static void main(String[] args) throws InterruptedException {
		int num = 100;
		StaticCounter counter = new StaticCounter();
		Thread[] threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			threads[i] = new StaticCounterThread(counter);
			threads[i].start();
		}
		for (int i = 0; i < num; i++) {
			threads[i].join();
		}
		System.out.println(StaticCounter.getCount());
	}
}
