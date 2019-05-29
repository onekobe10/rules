package com.gankki.demo.ma.linkedhash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/1
 */
public class LinkedHashMapTest {
	
	
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();

		map.put("c", 100);
		map.put("d", 200);
		map.put("a", 500);
		map.put("d", 300);

		for(Map.Entry<String,Integer> entry : map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		System.out.println("-----------------------");

		/**
		 * LinkedHashMap支持两种顺序，一种是插入顺序，另外一种是访问顺序。
		 *
		 * 插入顺序容易理解，先添加的在前面，后添加的在后面，修改操作不影响顺序。
		 */
		Map<String,Integer> seqMap = new LinkedHashMap<>(10, 0.75f, true);

		seqMap.put("c", 100);
		seqMap.put("d", 200);
		seqMap.put("a", 500);
		seqMap.put("d", 300);

		for(Map.Entry<String,Integer> entry : seqMap.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

	}
}
