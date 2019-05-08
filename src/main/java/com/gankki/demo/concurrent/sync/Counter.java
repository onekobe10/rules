package com.gankki.demo.concurrent.sync;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/8
 */
public class Counter {
	private int count;
	private Object lock = new Object();

	/**
	 * 同步方法
	 */
	public synchronized void incr(){
		count ++;
	}

	/**
	 * 同步代码块
	 */
	public void incr2(){
		synchronized(this){
			count ++;
		}
	}

	/**
	 * synchronized 同步的对象可以是任意对象，任意对象都有一个锁和等待队列，或者说，任何对象都可以作为锁对象。
	 * 只要同步的独享有意义即可
	 */
	public void incr3(){
		synchronized(lock){
			count ++;
		}
	}

	public synchronized int getCount() {
		return count;
	}
}
