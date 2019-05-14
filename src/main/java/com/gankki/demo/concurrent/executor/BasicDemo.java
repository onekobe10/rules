package com.gankki.demo.concurrent.executor;

import java.util.Random;
import java.util.concurrent.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class BasicDemo {
	static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int sleepSeconds = new Random().nextInt(1000);
			System.out.println(sleepSeconds);
			System.out.println(1);
			Thread.sleep(sleepSeconds);
			return sleepSeconds;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		// 通过实现AbstractExecutorService，实现一个类似功能的异步服务
		ExecutorService executor2 = new SimpleExecutorService();
		// 提交了一个任务，提交后，可以继续执行其他事情，随后可以通过Future获取最终结果或处理任务执行的异常。
		Future<Integer> future = executor.submit(new Task());

		// 模拟执行其他任务
		Thread.sleep(100);

		try {
			System.out.println(future.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
}
