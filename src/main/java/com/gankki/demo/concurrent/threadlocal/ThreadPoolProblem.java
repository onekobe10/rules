package com.gankki.demo.concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class ThreadPoolProblem {

	static ThreadLocal<AtomicInteger> sequencer = new ThreadLocal<AtomicInteger>() {

		@Override
		protected AtomicInteger initialValue() {
			return new AtomicInteger(0);
		}
	};

	static class Task implements Runnable {

		@Override
		public void run() {
			AtomicInteger s = sequencer.get();
			int initial = s.getAndIncrement();
			// 期望初始为0
			System.out.println(initial);
		}
	}

	static class Task2 implements Runnable {

		@Override
		public void run() {
			sequencer.set(new AtomicInteger(0));
			//或者 sequencer.remove();

			AtomicInteger s = sequencer.get();
			//...
			System.out.println(s);
		}
	}

	static class Task3 implements Runnable {

		@Override
		public void run() {
			try{
				AtomicInteger s = sequencer.get();
				int initial = s.getAndIncrement();
				// 期望初始为0
				System.out.println(initial);
			}finally{
				sequencer.remove();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.shutdown();
		System.out.println(executor.isTerminated());

		/**
		 * 此处应该是调用其他加入此线程的线程的join方法，而不是此线程的join方法
		 * 如果在此线程中调用此线程自己的join方法，就会造成死锁。
		 */
		Thread.currentThread().join();
		System.out.println("-------------------------");

		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		executor2.execute(new Task2());
		executor2.execute(new Task2());
		executor2.execute(new Task2());
		executor2.shutdown();
	}
}
