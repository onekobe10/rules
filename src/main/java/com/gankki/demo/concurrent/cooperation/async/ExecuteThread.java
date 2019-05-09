package com.gankki.demo.concurrent.cooperation.async;

import java.util.concurrent.Callable;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class ExecuteThread<V> extends Thread {
	private V result = null;
	private Exception exception = null;
	private boolean done = false;
	private Callable<V> task;
	private Object lock;

	public ExecuteThread(Callable<V> task, Object lock) {
		this.task = task;
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			result = task.call();
		} catch (Exception e) {
			exception = e;
		} finally {
			synchronized (lock) {
				done = true;
				lock.notifyAll();
			}
		}
	}

	public V getResult() {
		return result;
	}

	public boolean isDone() {
		return done;
	}

	public Exception getException() {
		return exception;
	}
}
