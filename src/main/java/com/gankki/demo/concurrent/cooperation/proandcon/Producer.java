package com.gankki.demo.concurrent.cooperation.proandcon;

import com.gankki.demo.concurrent.cooperation.proandcon.MyBlockingQueue;

/**
 *@desc 生产者
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Producer extends Thread {
	MyBlockingQueue<String> queue;

	public Producer(MyBlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int num = 0;
		try {
			while (true) {
				String task = String.valueOf(num);
				queue.put(task);
				System.out.println("produce task " + task);
				num++;
				Thread.sleep((int) (Math.random() * 100));
			}
		} catch (InterruptedException e) {
		}
	}
}
