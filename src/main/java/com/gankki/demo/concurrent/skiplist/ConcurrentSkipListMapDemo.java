package com.gankki.demo.concurrent.skiplist;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/13
 */
public class ConcurrentSkipListMapDemo {

	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentSkipListMap<>(
				Collections.reverseOrder());
		map.put("a", "abstract");
		map.put("c", "call");
		map.put("b", "basic");
		System.out.println(map.toString());
	}
}
