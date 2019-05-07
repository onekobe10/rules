package com.gankki.demo.oldthread.thread.threadcommunication;

public class Test {
	public static void main(String[] args) {
		Goods g = new Goods();
		Productor productor = new Productor(g);
		Customer  customer = new Customer(g);
		
		Thread t1 = new Thread(productor);
		Thread t2 = new Thread(customer);
		
		t1.start();
		t2.start();
		
	}
}
