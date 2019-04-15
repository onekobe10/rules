package com.gankki.demo.ma;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {


	public static void main(String[] args){
		Map<String,Integer> countMap = new HashMap<>(8);
		countMap.put("hello", 1);
		countMap.put("world", 3);

		countMap.put("position", 4);

	}
}
