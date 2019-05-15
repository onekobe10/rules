package com.gankki.demo.concurrent.threadlocal;

import java.lang.reflect.Field;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class MyThreadPool extends ThreadPoolExecutor {
	static ThreadLocal<AtomicInteger> sequencer = new ThreadLocal<AtomicInteger>() {

		@Override
		protected AtomicInteger initialValue() {
			return new AtomicInteger(0);
		}
	};

	static class Task implements Runnable {

		@Override
		public void run() {
			AtomicInteger s = sequencer.get();
			int initial = s.getAndIncrement();
			// 期望初始为0
			System.out.println(initial);
		}
	}

	public MyThreadPool(int corePoolSize, int maximumPoolSize,
						long keepAliveTime, TimeUnit unit,
						BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		try {
			//使用反射清空所有ThreadLocal
			Field f = t.getClass().getDeclaredField("threadLocals");
			f.setAccessible(true);
			f.set(t, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.beforeExecute(t, r);
	}

	public static void main(String[] args) {
		ExecutorService executor = new MyThreadPool(2, 2, 0,
				TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.shutdown();
	}

}
