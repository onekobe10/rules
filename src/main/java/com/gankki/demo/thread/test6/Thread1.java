package com.gankki.demo.thread.test6;

public class Thread1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i+".........");
		}
	}
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
		for (int i = 100; i < 200; i++) {
			System.out.println(i+"........");
		}
	}
	
}
