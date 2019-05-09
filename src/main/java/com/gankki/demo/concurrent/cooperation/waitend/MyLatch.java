package com.gankki.demo.concurrent.cooperation.waitend;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class MyLatch {
	private int count;

	public MyLatch(int count) {
		this.count = count;
	}

	public synchronized void await() throws InterruptedException {
		while (count > 0) {
			wait();
		}
	}

	public synchronized void countDown() {
		count--;
		if (count <= 0) {
			notifyAll();
		}
	}
}
