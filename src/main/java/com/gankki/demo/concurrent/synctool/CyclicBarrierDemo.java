package com.gankki.demo.concurrent.synctool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class CyclicBarrierDemo {
	static class Tourist extends Thread {
		CyclicBarrier barrier;

		public Tourist(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				// 模拟先各自独立运行
				Thread.sleep((int) (Math.random() * 1000));

				// 集合点A
				barrier.await();

				System.out.println(this.getName() + " arrived A "
						+ System.currentTimeMillis());

				// 集合后模拟再各自独立运行
				Thread.sleep((int) (Math.random() * 1000));

				// 集合点B
				barrier.await();
				System.out.println(this.getName() + " arrived B "
						+ System.currentTimeMillis());
			} catch (InterruptedException e) {
			} catch (BrokenBarrierException e) {
			}
		}
	}

	/**
	 * 多个线程到达A和B的时间是一样的，使用CyclicBarrier，达到了重复同步的目的。
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 3;
		Tourist[] threads = new Tourist[num];
		CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {

			@Override
			public void run() {
				System.out.println("all arrived " + System.currentTimeMillis()
						+ " executed by " + Thread.currentThread().getName());
			}
		});
		for (int i = 0; i < num; i++) {
			threads[i] = new Tourist(barrier);
			threads[i].start();
		}
	}
}
