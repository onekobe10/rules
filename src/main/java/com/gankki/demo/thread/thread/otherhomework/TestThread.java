package com.gankki.demo.thread.thread.otherhomework;

public class TestThread {

	private int j = 0;

	public static void main(String[] args) {
		TestThread tt = new TestThread();
		
		InnerAdd iAdd1 = tt.new InnerAdd();
		InnerAdd iAdd2 = tt.new InnerAdd();
		Thread t1 = new Thread(iAdd1, "�ӷ��߳�1");
		Thread t2 = new Thread(iAdd2, "�ӷ��߳�2");
		
		InnerMinus iMinus1 = tt.new InnerMinus();
		InnerMinus iMinus2 = tt.new InnerMinus();
		Thread t3 = new Thread(iMinus1, "�����߳�3");
		Thread t4 = new Thread(iMinus2, "�����߳�4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public synchronized void add() {
		System.out.println(j++ + Thread.currentThread().getName());
	}
	class InnerAdd implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				add();
			}
		}

	}

	public synchronized void minus() {
		System.out.println(j-- + Thread.currentThread().getName());
	}
	class InnerMinus implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				minus();
				
			}
		}

	}
}
