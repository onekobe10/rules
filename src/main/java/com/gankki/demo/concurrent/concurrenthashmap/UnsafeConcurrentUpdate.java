package com.gankki.demo.concurrent.concurrenthashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/13
 */
public class UnsafeConcurrentUpdate {

	public static void unsafeConcurrentUpdate() {
		final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread() {
				Random rnd = new Random();

				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						map.put(rnd.nextInt(), 1);
					}
				}
			};
			t.start();
		}
	}

	/**
	 * 并发状态下HashMap导致 CPU 占用100%问题重现
	 * @param args
	 */
	public static void main(String[] args){
	    unsafeConcurrentUpdate();
	}
}
