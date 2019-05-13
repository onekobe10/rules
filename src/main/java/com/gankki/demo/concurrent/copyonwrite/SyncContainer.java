package com.gankki.demo.concurrent.copyonwrite;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/8
 */
public class SyncContainer {

	private static void startModifyThread(final List<String> list) {
		Thread modifyThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					list.add("item " + i);
					try {
						Thread.sleep((int) (Math.random() * 10));
					} catch (InterruptedException e) {
					}
				}
			}
		});
		modifyThread.start();
	}

	private static void startIteratorThread2(final List<String> list) {
		Thread iteratorThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized(list){
						for (String str : list) {
						}
					}
				}
			}
		});
		iteratorThread.start();
	}

	private static void startIteratorThread(final List<String> list) {
		Thread iteratorThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					for (String str : list) {
					}
				}
			}
		});
		iteratorThread.start();
	}

	public static void sort(){
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("c");
		list.add("a");
		list.add("b");
		Collections.sort(list);
	}

	/**
	 * 如果在遍历的同时容器发生了结构性变化，就会抛出该异常，同步容器并没有解决这个问题，
	 * 如果要避免这个异常，需要在遍历的时候给整个容器对象加锁
	 * 改为startIteratorThread2方法即可，这样在遍历的时候是不能进行更新操作的
	 * @param args
	 */
	public static void main(String[] args) {
		final List<String> list = new CopyOnWriteArrayList<>();
		// startIteratorThread(list);
		// startModifyThread(list);

		sort();
	}
}
