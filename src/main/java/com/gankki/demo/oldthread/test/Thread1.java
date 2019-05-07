package com.gankki.demo.oldthread.test;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/7
 */
public class Thread1 extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "***");
		System.out.println(Thread.currentThread().getId() + "***");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+".........");
		}
	}
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
		for (int i = 20; i < 40; i++) {
			System.out.println(i+"........");
		}
	}
	
}
