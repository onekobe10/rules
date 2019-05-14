package com.gankki.demo.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class ThreadPoolDeadLockDemo {

	private static final int THREAD_NUM = 5;
	static ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

	static class TaskA implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Future<?> future = executor.submit(new TaskB());
			try {
				future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("finished task A");
		}
	}

	static class TaskB implements Runnable {
		@Override
		public void run() {
			System.out.println("finished task B");
		}
	}

	/**
	 * 以上代码使用newFixedThreadPool创建了一个5个线程的线程池，main程序提交了5个TaskA，
	 * TaskA会提交一个TaskB，然后等待TaskB结束，而TaskB由于线程已被占满只能排队等待，这样，程序就会死锁。
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			executor.execute(new TaskA());
		}
		Thread.sleep(2000);
		executor.shutdown();
	}
}
