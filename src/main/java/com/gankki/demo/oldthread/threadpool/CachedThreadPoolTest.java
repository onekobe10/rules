package com.gankki.demo.oldthread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存线程池
 * 如果创建的线程超过了处理需求，可灵活回收缓存多余线程
 * 不能设定线程池的Size
 * @author liuhao	
 *
 * 2018年3月13日
 */
public class CachedThreadPoolTest {
	
	ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool();
		
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		  for (int i = 0; i < 10; i++) {
			  final int index = i;
			  try {
			    Thread.sleep(index * 1000);
			  } 
			    catch (InterruptedException e) {
			      e.printStackTrace();
			  }
			 
			cachedThreadPool.execute(new Runnable() {
			 
				@Override
				public void run() {
				  System.out.println(index + "......" + Thread.currentThread().getName());
				}
			});
	   }

	}
}
