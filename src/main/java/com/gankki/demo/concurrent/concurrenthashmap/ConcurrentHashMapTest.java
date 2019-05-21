package com.gankki.demo.concurrent.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/21
 */
public class ConcurrentHashMapTest {

	public static void main(String[] args){
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("str", "str");
	}
}
