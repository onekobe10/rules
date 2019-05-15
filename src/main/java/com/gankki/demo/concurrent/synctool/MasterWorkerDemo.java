package com.gankki.demo.concurrent.synctool;

import java.util.concurrent.CountDownLatch;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class MasterWorkerDemo {
	static class Worker extends Thread {
		CountDownLatch latch;

		public Worker(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				// simulate working on task
				Thread.sleep((int) (Math.random() * 1000));

				// simulate exception
				if (Math.random() < 0.02) {
					throw new RuntimeException("bad luck");
				}
			} catch (InterruptedException e) {
			} finally {
				this.latch.countDown();
			}
		}
	}

	/**
	 * 在主从协作模式中，主线程依赖工作线程的结果，需要等待工作线程结束，这时，计数初始值为工作线程的个数，
	 * 工作线程结束后调用countDown，主线程调用await进行等待
	 * 	需要强调的是，在这里，countDown的调用应该放到finally语句中，确保在工作线程发生异常的情况下也会被调用，使主线程能够从await调用中返回。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int workerNum = 100;
		CountDownLatch latch = new CountDownLatch(workerNum);
		Worker[] workers = new Worker[workerNum];
		for (int i = 0; i < workerNum; i++) {
			workers[i] = new Worker(latch);
			workers[i].start();
		}
		/**
		 * Causes the current thread to wait until the latch has counted down to
		 *  zero, unless the thread is {@linkplain Thread#interrupt interrupted}.
		 */
		latch.await();
		System.out.println("collect worker results");
	}

}
