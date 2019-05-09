package com.gankki.demo.concurrent.thread;

/**
 *@desc Thread的join方法详解
 *@author liuhao
 *@createDate 2019/5/9
 */
public class JoinMethod {


	/**
	 * join方法
	 * join()方法阻塞调用此方法的线程(calling thread)，直到线程t完成，此线程再继续；
	 * 通常用于在main()主线程内，等待其它线程完成再结束main()主线程。
	 *
	 *  Thread中join，start等方法都是synchronized修饰的
	 *  start方法启动一个线程之后就会释放同步锁，然后join方法获取调用线程的同步锁，调用了wait()方法
	 *  哪个线程调用了wait方法就会wait，所以并不是threadA进入wait状态，而是调用这个方法的线程wait
	 *	Causes the current thread to wait until another thread invokes the notify() method
	 *		or the notifyAll() method for this object.
	 *
	 *	首先join() 是一个synchronized方法， 里面调用了wait()，这个过程的目的是让持有这个同步锁的线程进入等待，
	 *	那么谁持有了这个同步锁呢？答案是主线程，因为主线程调用了threadA.join()方法，
	 *	相当于在threadA.join()代码这块写了一个同步代码块，谁去执行了这段代码呢，是主线程，所以主线程被wait()了。
	 *	然后在子线程threadA执行完毕之后，JVM会调用lock.notify_all(thread);
	 *	唤醒持有threadA这个对象锁的线程，也就是主线程，会继续执行。
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("MainThread run start.");
		//启动一个子线程
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("threadA run start.");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("threadA run finished.");
			}
		});
		threadA.start();

		System.out.println("MainThread join before");
		try {
			threadA.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MainThread run finished.");
	}
	
}
