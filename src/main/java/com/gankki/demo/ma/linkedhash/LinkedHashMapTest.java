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
		
		Map<String,Integer> seqMap = new LinkedHashMap<>();

		seqMap.put("c", 100);
		seqMap.put("d", 200);
		seqMap.put("a", 500);
		seqMap.put("d", 300);

		for(Map.Entry<String,Integer> entry : seqMap.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

	}
}
