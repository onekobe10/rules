package com.gankki.demo.concurrent.cooperation.waitend;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Worker extends Thread {
	MyLatch latch;

	public Worker(MyLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			// simulate working on task
			Thread.sleep((int) (Math.random() * 1000));

			this.latch.countDown();
		} catch (InterruptedException e) {
		}
	}
}
