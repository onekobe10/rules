package com.gankki.demo.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 其他线程交给线程池处理之后，会由线程池中的线程（不会超出线程池的Size）去处理托管线程
 * 加入线程池的线程是由托管线程处理的
 * @author liuhao	
 *
 * 2018年3月13日
 */
public class NewFixedThreadPoolTest {
	
	public static void main(String[] args) { 
	    // 创建一个可重用固定线程数的线程池 
	    ExecutorService pool = Executors.newFixedThreadPool(2); 
	    // 创建线程 
	    Thread t1 = new MyThread(); 
	    Thread t2 = new MyThread(); 
	    Thread t3 = new MyThread(); 
	    Thread t4 = new MyThread(); 
	    Thread t5 = new MyThread(); 
	    // 将线程放入池中进行执行 
	    pool.execute(t1); 
	    pool.execute(t2); 
	    pool.execute(t3); 
	    pool.execute(t4); 
	    pool.execute(t5); 
	    // 关闭线程池 
	    pool.shutdown(); 
	  } 
	} 
	 
	class MyThread extends Thread { 
	  @Override
	  public void run() { 
	    System.out.println(Thread.currentThread().getName() + "正在执行。。。"); 
	  } 

}
