package com.gankki.demo.concurrent.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/13
 */
public class ConcurrentHashMapIteratorDemo {

	public static void test() {
		final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("a", "abstract");
		map.put("b", "basic");
		map.put("d", "basic");
		map.put("e", "basic");

		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println(entry.getKey() + "," + entry.getValue());
				}
			}
		};
		t1.start();
		// 确保线程t1启动
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		map.put("1", "call");
	}

	public static void main(String[] args) {
		test();
	}
}
