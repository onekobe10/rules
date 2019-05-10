package com.gankki.demo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/10
 */
public class MyLock {

	private AtomicInteger status = new AtomicInteger(0);

	/**
	 * 1 表示 锁定 0 表示 未锁定
	 */
	public void lock() {
		while (!status.compareAndSet(0, 1)) {
			Thread.yield();
		}
	}

	public void unlock() {
		status.compareAndSet(1, 0);
	}
}
