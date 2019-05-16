package com.gankki.demo.concurrent.thread;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/16
 */
public class joindeadlock {

	/**
	 * join()方法阻塞调用此方法的线程(calling thread)，直到join方法所属的实例线程执行完毕，此线程再继续。
	 * 调用join方法的线程和join方法所属的实例线程不是一个线程！
	 * 也就是如果在当前线程中调用了当前线程的join方法，则造成死锁。
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{

		//启动一个子线程
		Thread threadA = new Thread(() -> {
				System.out.println("threadA run start.");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("threadA run finished.");
			});
		threadA.start();

		Thread threadB = new Thread(() -> System.out.println("1"));
		threadB.start();

		threadA.join();
		threadB.join();
		// 导致死锁
		//Thread.currentThread().join();
		//System.out.println("永远不会执行......");

	}
}
