package com.gankki.demo.concurrent.cooperation.syncstart;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class FireFlag {
	private volatile boolean fired = false;

	public synchronized void waitForFire() throws InterruptedException {
		while (!fired) {
			wait();
		}
	}

	public synchronized void fire() {
		this.fired = true;
		notifyAll();
	}
}
