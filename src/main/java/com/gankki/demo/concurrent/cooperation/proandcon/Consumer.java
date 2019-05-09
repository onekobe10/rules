package com.gankki.demo.concurrent.cooperation.proandcon;

/**
 *@desc 消费者
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Consumer extends Thread {
	MyBlockingQueue<String> queue;

	public Consumer(MyBlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String task = queue.take();
				System.out.println("consumer task " + task);
				Thread.sleep((int)(Math.random()*100));
			}
		} catch (InterruptedException e) {
		}
	}
}
