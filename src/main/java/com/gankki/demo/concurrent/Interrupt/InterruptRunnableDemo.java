package com.gankki.demo.concurrent.Interrupt;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class InterruptRunnableDemo extends Thread {
	@Override
	public void run() {
		// 检查中断的标志位代码
		while (!Thread.currentThread().isInterrupted()) {
			// ... 单次循环代码
			System.out.println(1);
		}
		System.out.println("done ");
	}

	/**
	 * 如果线程在运行中，且没有执行IO操作，interrupt()只是会设置线程的中断标志位，
	 * 没有任何其它作用。线程应该在运行过程中合适的位置检查中断标志位
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new InterruptRunnableDemo();
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
	}
}
