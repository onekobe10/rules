package com.gankki.demo.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 固定线程池
 * 可控制线程的最大并发数，超出的线程会在队列中等待
 * @author liuhao	
 *
 * 2018年3月13日
 */
public class FixedThreadPoolTest {
	
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		  	for (int i = 0; i < 10; i++) {
			final int index = i;
		 
		  	fixedThreadPool.execute(new Runnable() {
				
		  		@Override
				public void run() {
					try {
					  System.out.println(index + "....." + Thread.currentThread().getName());
					  Thread.sleep(3000);
					} catch (InterruptedException e) {
					  e.printStackTrace();
					  }
				}
			});
		}

	}
}
