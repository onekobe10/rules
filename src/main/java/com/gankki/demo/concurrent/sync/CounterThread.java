package com.gankki.demo.concurrent.sync;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/8
 */
public class CounterThread extends Thread {
	Counter counter;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 10));
		} catch (InterruptedException e) {
		}
		counter.incr();
	}

	/**
	 * 当多个线程并发执行counter++的时候，由于该语句不是原子操作，出现了意料之外的结果，这个问题可以用synchronized解决。
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int num = 100;
		Counter counter = new Counter();
		Thread[] threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			threads[i] = new CounterThread(counter);
			threads[i].start();
		}
		for (int i = 0; i < num; i++) {
			threads[i].join();
		}
		System.out.println(counter.getCount());
	}
}
