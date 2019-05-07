package com.gankki.demo.oldthread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定长且支持定时和周期性任务执行线程池
 * ScheduledExecutorService比Timer更安全，功能更强大
 * @author liuhao	
 *
 * 2018年3月13日
 */
public class ScheduledThreadPoolTest {
	
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		 scheduledThreadPool.schedule(new Runnable() {
		 
		@Override
		public void run() {
		  System.out.println("delay 3 seconds");
		}
		}, 3, TimeUnit.SECONDS);
		 
		 /*
		  * 延迟1秒后每三秒执行一次 周期执行
		  scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			 
		 @Override
		 public void run() {
		   System.out.println("delay 1 seconds, and excute every 3 seconds");
		 }
		 }, 1, 3, TimeUnit.SECONDS);
		 
		 */

	}
}
