package com.gankki.demo.concurrent.cooperation.async;

import java.util.concurrent.Callable;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class MyExecutor {

	public <V> MyFuture<V> execute(final Callable<V> task) {
		final Object lock = new Object();
		final ExecuteThread<V> thread = new ExecuteThread<>(task, lock);
		thread.start();

		MyFuture<V> future = new MyFuture<V>() {
			@Override
			public V get() throws Exception {
				synchronized (lock) {
					while (!thread.isDone()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
						}
					}
					if (thread.getException() != null) {
						throw thread.getException();
					}
					return thread.getResult();
				}
			}
		};
		return future;
	}

}
