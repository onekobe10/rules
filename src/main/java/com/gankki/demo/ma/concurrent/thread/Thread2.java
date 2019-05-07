package com.gankki.demo.ma.concurrent.thread;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/7
 */
public class Thread2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
		System.out.println(Thread.currentThread().isDaemon());
	}

	public static void main(String[] args) throws Exception {
		Thread2 t2 = new Thread2();

		Thread thread1 = new Thread(t2, "线程1  ");
		Thread thread2 = new Thread(t2, "线程2  ");

		System.out.println(thread1.getState() + ".....main");
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		System.out.println(thread1.getState() + ".....main");

	}
}
