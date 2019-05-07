package com.gankki.demo.oldthread.thread.homework;

public class SaleTicket implements Runnable {
	public int totalTickets = 1;

	@Override
	public void run() {

		while(true){
			
			synchronized (this) {
				if (totalTickets < 101) {
					System.out.println(Thread.currentThread().getName() + "���˵�" + totalTickets++ + "Ʊ��");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (totalTickets > 100) {
					break;
				}
			}
		}

	}

}
