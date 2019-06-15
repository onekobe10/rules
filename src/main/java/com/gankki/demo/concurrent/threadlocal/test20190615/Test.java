package com.gankki.demo.concurrent.threadlocal.test20190615;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuhao
 * @desc
 * @createDate 2019/6/15
 */
public class Test extends Thread {

	static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

	static ThreadLocal<List<Integer>> threadLocal1 = new ThreadLocal<List<Integer>>() {

		@Override

		protected List<Integer> initialValue() {

			return list;

		}
	};

	static ThreadLocal<List<Integer>> threadLocal2 = ThreadLocal.withInitial(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));


	@Override
	public void run() {

		List<Integer> threadList = threadLocal2.get();

		threadList.add(threadList.size());

		System.out.println(threadList.toString());

	}

	/**
	 * threadLocal1中initialValue返回的一个静态变量，在每个线程中的本地变量中只是获得了这个变量的引用，线程不安全
	 * threadLocal2中每个线程本地变量是初始化的arrayList，因此在每个线程对这个本地变量的修改是线程安全的
	 *
	 * @param args
	 */
	public static void main(String[] args){
		new Test().start();

		new Test().start();

		new Test().start();

		new Test().start();
	}



}
