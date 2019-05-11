package com.gankki.demo.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/11
 */
public class LockSupportDemo {

	/**
	 * park使得当前线程放弃CPU，进入等待状态(WAITING)，操作系统不再对它进行调度，什么时候再调度呢？
	 * 有其他线程对它调用了unpark，unpark需要指定一个线程，unpark会使之恢复可运行状态。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread (){

			@Override
			public void run(){
				LockSupport.park();
				System.out.println("exit");
			}
		};
		t.start();
		Thread.sleep(3000);
		LockSupport.unpark(t);
	}
}
