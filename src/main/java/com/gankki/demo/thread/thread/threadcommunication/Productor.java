package com.gankki.demo.thread.thread.threadcommunication;

public class Productor implements Runnable {

	Goods g;

	public Productor(Goods g) {
		super();
		this.g = g;
	}

	public Productor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		while (true) {
			synchronized (g) {
				String str = "����" + (int) (Math.random() * 101) + "����Ʒ";

				g.setMessage(str);
				System.out.println(g.getMessage() + "������");
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
