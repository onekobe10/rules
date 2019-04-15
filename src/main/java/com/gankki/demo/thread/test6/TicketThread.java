package com.gankki.demo.thread.test6;

public class TicketThread implements Runnable{
	private   int tick=30;

	@Override
	public void run() {
		while(true){
			synchronized (this) {
				if (tick>0) {
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"...卖票:"+tick--);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("测试1............");
		TicketThread tt = new TicketThread();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		System.out.println("测试2........");
		
	}

}
