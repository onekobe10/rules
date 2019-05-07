package com.gankki.demo.oldthread.thread.threadcommunication;

public class Customer implements Runnable {

	Goods g;

	public Customer(Goods g) {
		super();
		this.g = g;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (true) {
			synchronized (g) {
				if (g.getMessage() == null) {
					Thread.currentThread().yield();
				}
				System.out.println(g.getMessage() + "�����������������������������������������������������ˡ�");
				g.notify();
				try {
					g.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
