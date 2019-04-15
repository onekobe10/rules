package com.gankki.demo.ma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/3/23
 */
public class TreeMapTest {
	
	public static void main(String[] args){
		// Map<String, String> map  = new TreeMap<>();
		// Map<String, String> map  = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		Map<String, String> map = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// o1表示当前put方法中的key，o2表示map中存在的key
				return o1.compareTo(o2);
			}
		});
		map.put("a", "abstract");
		map.put("c", "call");
		map.put("b", "basic");
		map.put("T", "tree");

		for(Map.Entry<String,String> kv : map.entrySet()){
			System.out.print(kv.getKey()+"="+kv.getValue()+"\n");
		}

		System.out.println("1---------------------------------");

		Map<String, String> map2 = new TreeMap<>(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		map2.put("a", "abstract");
		map2.put("c", "call");
		map2.put("b", "basic");
		map2.put("T", "tree");

		for(Map.Entry<String,String> kv : map2.entrySet()){
			System.out.print(kv.getKey()+"="+kv.getValue()+"\n");
		}

		System.out.println("2---------------------------------");

		Map<String, Integer> map3  = new TreeMap<>(new Comparator<String>() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			@Override
			public int compare(String o1, String o2) {
				try {
					return sdf.parse(o1).compareTo(sdf.parse(o2));
				} catch (ParseException e) {
					e.printStackTrace();
					return 0;
				}
			}
		});
		map3.put("2016-7-3", 100);
		map3.put("2016-7-10", 120);
		map3.put("2016-8-1", 90);

		for(Map.Entry<String,Integer> kv : map3.entrySet()){
			System.out.println(kv.getKey()+","+kv.getValue());
		}
		System.out.println("3---------------------------------");

		NavigableMap<String, String> map4  = new TreeMap<>();
		map4.put("a", "abstract");
		map4.put("f", "final");
		map4.put("c", "call");
		map4.put("d", "dell");

		//输出：a=abstract
		System.out.println(map4.firstEntry());

		//输出：f=final
		System.out.println(map4.lastEntry());

		//输出：c=call
		System.out.println(map4.floorEntry("d"));
		//输出：c=call
		System.out.println(map4.lowerEntry("d"));

		//输出：f=final
		System.out.println(map4.ceilingEntry("d"));

		//输出：{c=call, a=abstract}
		System.out.println(map4.descendingMap()
				.subMap("d", false, "a", true));



	}
}
