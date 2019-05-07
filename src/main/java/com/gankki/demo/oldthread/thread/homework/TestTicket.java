package com.gankki.demo.oldthread.thread.homework;

public class TestTicket {
	public static void main(String[] args) {
		SaleTicket sale = new SaleTicket();
		Thread th1 = new Thread(sale);
		Thread th2 = new Thread(sale);
		Thread th3 = new Thread(sale);
		Thread th4 = new Thread(sale);
		Thread th5 = new Thread(sale);
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		
		try {
			th1.join();
			th1.join();
			th1.join();
			th1.join();
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ʊ�����ˣ����´�������");
		
	}
}
