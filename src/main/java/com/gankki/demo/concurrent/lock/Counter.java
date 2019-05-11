package com.gankki.demo.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/11
 */
public class Counter {
	private final Lock lock = new ReentrantLock();
	private volatile int count;

	public void incr() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}
}
