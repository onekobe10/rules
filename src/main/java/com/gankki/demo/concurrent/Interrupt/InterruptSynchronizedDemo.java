package com.gankki.demo.concurrent.Interrupt;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class InterruptSynchronizedDemo {
	private static Object lock = new Object();

	private static class A extends Thread {
		@Override
		public void run() {
			synchronized (lock) {
				while (!Thread.currentThread().isInterrupted()) {
					System.out.println("1");
				}
			}
			System.out.println("exit");
		}
	}

	/**
	 * test方法在持有锁lock的情况下启动线程a，而线程a也去尝试获得锁lock，所以会进入锁等待队列，
	 * 随后test调用线程a的interrupt方法并等待线程线程a结束，线程a会结束吗？不会，
	 * interrupt方法只会设置线程的中断标志，而并不会使它从锁等待队列中出来。
	 * @throws InterruptedException
	 */
	public static void test() throws InterruptedException {
		synchronized (lock) {
			A a = new A();
			a.start();
			Thread.sleep(1000);

			a.interrupt();
			// 如果没有a.join()此时执行test()方法的线程就会执行完毕，释放lock锁，然后线程a获取锁之后，发现中断标志位为true就会执行后面的代码了。
			a.join();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		test();
	}
}
