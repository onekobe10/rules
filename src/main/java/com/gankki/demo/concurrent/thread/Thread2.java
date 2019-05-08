package com.gankki.demo.concurrent.thread;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/7
 */
public class Thread2 implements Runnable {

	@Override
	public void run() {
		// 线程id
		System.out.println(Thread.currentThread().getId());
		// 线程名称
		System.out.println(Thread.currentThread().getName());
		// 线程优先级
		System.out.println(Thread.currentThread().getPriority());
		// 线程状态
		System.out.println(Thread.currentThread().getState());
		// 是否为守护线程
		System.out.println(Thread.currentThread().isDaemon());
		// 线程是否还活着
		System.out.println(Thread.currentThread().isAlive());
		// 线程是否被中断
		System.out.println(Thread.currentThread().isInterrupted());
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
