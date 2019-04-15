package com.gankki.demo.thread.test6;

public class Thead2 implements Runnable {
	int x = 100;
	// @Override
	// public void run() {
	// synchronized (this){
	// for (int i = 0; i < 200; i++) {
	// this.notify();
	// System.out.println(Thread.currentThread().getName()+i+"........");
	// }
	// }
	// }

	@Override
	public synchronized void run() {
		for (int i = x; i > 1;) {
			System.out.println(Thread.currentThread().getName() + i-- + "...");
			if (i < 1) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		 Thead2 t2 = new Thead2();
		// Thread thread = new Thread(t2,"线程1 ");
		// thread.start();
		// for (int i = 100; i < 200; i++) {
		// System.out.println(i+".........");
		// }
		// Thead2 t3 = new Thead2();
		// Thread thread2 = new Thread(t3, "线程2 ");
		// thread2.start();

		Thread thread1 = new Thread(t2, "线程1  ");
		Thread thread2 = new Thread(t2, "线程2  ");

		thread1.start();
		thread2.start();

	}
}
