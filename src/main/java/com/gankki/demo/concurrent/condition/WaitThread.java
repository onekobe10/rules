package com.gankki.demo.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/11
 */
public class WaitThread extends Thread{
	private volatile boolean fire = false;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();
			try {
				while (!fire) {
					condition.await();
				}
			} finally {
				lock.unlock();
			}
			System.out.println("fired");
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
	}

	public void fire() {
		lock.lock();
		try {
			this.fire = true;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WaitThread waitThread = new WaitThread();
		waitThread.start();
		Thread.sleep(3000);
		System.out.println("fire");
		waitThread.fire();
	}
}
