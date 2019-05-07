package com.gankki.demo.ma.concurrent.thread;

/**
 *@desc 竞态条件(race condition)是指，当多个线程访问和操作同一个对象时，最终执行结果与执行时序有关，可能正确也可能不正确
 *@author liuhao
 *@createDate 2019/5/7
 */
public class CounterThread extends Thread {
	private static int counter = 0;

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int num = 100;
		Thread[] threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			threads[i] = new CounterThread();
			threads[i].start();
		}

		for (int i = 0; i < num; i++) {
			threads[i].join();
		}

		/**
		 * counter 期望值是100000，但结果往往不是
		 *
		 * counter++这个操作不是原子操作，执行的过程:
		 *  1.取counter的当前值
		 *  2.在当前值基础上加1
		 *  3.将新值重新赋值给counter
		 *
		 * 两个线程可能同时执行第一步，取到了相同的counter值，
		 * 比如都取到了100，第一个线程执行完后counter变为101，而第二个线程执行完后还是101，最终的结果就与期望不符。
		 *
		 * 解决办法：
		 * 	1.使用synchronized关键字
		 *  2.使用显式锁
		 *  3.使用原子变量
		 */
		System.out.println(counter);
	}
}
