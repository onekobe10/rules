package com.gankki.demo.oldthread.thread.test;

public class Test {
	public static void main(String[] args) {

		System.out.println("����main������");
		
		Thread thread = Thread.currentThread();
		System.out.println("Ŀǰ���߳��ǣ�" + thread.getName());
		
		FirstThread ftThread = new FirstThread();
		ftThread.start();
		
		SecondThead sThead = new SecondThead();
		Thread thread2 = new Thread(sThead);
		thread2.start();  
		
		for (int i = 0; ; i++) {
			if (i % 1000000000 == 0) {
				System.out.println("��ã�С�¡�");
			}
		}
	}
}
