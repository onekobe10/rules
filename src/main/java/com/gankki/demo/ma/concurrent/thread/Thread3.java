package com.gankki.demo.ma.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/7
 */
public class Thread3 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return 1;
	}

	public static void main(String[] args) throws  Exception {
		Thread3 tt = new Thread3();
		FutureTask<Integer> ft = new FutureTask<>(tt);
		new Thread(ft,"有返回值的线程").start();
		System.out.println(ft.get() + "....");
		for(int i=0;i<5;i++){
			System.out.println("main-->"+i);
		}
	}
}
