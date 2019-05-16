package com.gankki.demo.concurrent.cooperation;

/**
 *@desc wait/notify测试
 *@author liuhao
 *@createDate 2019/5/9
 */
public class WaitThread extends Thread {
	private volatile boolean fire = false;

	{
		synchronized (WaitThread.class) {
			// ...
		}
	}
	@Override
	public void run() {
		try {
			synchronized (this) {
				System.out.println("sync");
				while (!fire) {
					wait();
					System.out.println("1....");
				}
			}
			System.out.println("fired");
		} catch (InterruptedException e) {
		}
	}

	/**
	 * 调用notify会把在条件队列中等待的线程唤醒并从队列中移除，但它不会释放对象锁，
	 * 也就是说，只有在包含notify的synchronized代码块执行完后，等待的线程才会从wait调用中返回。
	 */
	public synchronized void fire() {
		this.fire = true;
		notify();
		System.out.println("notify...");
	}

	public static void main(String[] args) throws InterruptedException {
		WaitThread waitThread = new WaitThread();
		waitThread.start();
		Thread.sleep(3000);
		//System.out.println("fire");
		waitThread.fire();
	}
}
