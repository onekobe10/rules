package com.gankki.demo.oldthread.thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThreadCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		int count =0;  	
        for(int i=0;i<=10;i++){ 
        	System.out.println(i+"..............");
            count=count+i;  
        }  
        return count;   
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThirdThreadCallable tt = new ThirdThreadCallable();
		FutureTask<Integer> ft = new FutureTask<>(tt);
		new Thread(ft,"有返回值的线程").start();
		System.out.println(ft.get());
		
		for(int i=0;i<30;i++){
            System.out.println("main-->"+i);
        }
				
	}

}
