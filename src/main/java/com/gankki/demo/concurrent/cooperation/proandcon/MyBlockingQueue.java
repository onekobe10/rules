package com.gankki.demo.concurrent.cooperation.proandcon;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *@desc 有限队列
 *@author liuhao
 *@createDate 2019/5/9
 */
public class MyBlockingQueue<E> {
	private Queue<E> queue = null;
	private int limit;

	public MyBlockingQueue(int limit) {
		this.limit = limit;
		queue = new ArrayDeque<>(limit);
	}

	public synchronized void put(E e) throws InterruptedException {
		while (queue.size() == limit) {
			wait();
		}
		queue.add(e);
		notifyAll();
	}

	public synchronized E take() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		E e = queue.poll();
		notifyAll();
		return e;
	}
}
