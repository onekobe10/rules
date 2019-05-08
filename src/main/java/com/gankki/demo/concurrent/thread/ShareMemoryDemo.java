package com.gankki.demo.concurrent.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *@desc 共享内存
 *@author liuhao
 *@createDate 2019/5/7
 */
public class ShareMemoryDemo {
	private static int shared = 0;

	private static void incrShared(){
		shared ++;
	}

	static class ChildThread extends Thread {
		List<String> list;

		public ChildThread(List<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			incrShared();
			list.add(Thread.currentThread().getName());
		}
	}

	/**
	 *
	 * 该例中有三条执行流，一条执行main方法，另外两条执行ChildThread的run方法。
	 * 不同执行流可以访问和操作相同的变量，如本例中的shared和list变量。
	 * 不同执行流可以执行相同的程序代码，如本例中incrShared方法，
	 * 	 ChildThread的run方法，被两条ChildThread执行流执行，incrShared方法是在外部定义的，
	 * 	 但被ChildThread的执行流执行，在分析代码执行过程时，理解代码在被哪个线程执行是很重要的。
	 * 当多条执行流执行相同的程序代码时，每条执行流都有单独的栈，方法中的参数和局部变量都有自己的一份。
	 *
	 */
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<>();

		// 只有在当前类中才可以不使用类名直接 new 静态内部类，如果不是静态内部类，只有外部类创建了之后才可以创建
		Thread t1 = new ChildThread(list);
		Thread t2 = new ChildThread(list);
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		// 只有在当前类中才可以不加类名使用静态的成员变量
		System.out.println(shared);
		System.out.println(list);
	}
}
