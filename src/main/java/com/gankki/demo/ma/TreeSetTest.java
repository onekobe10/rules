package com.gankki.demo.ma;

import java.util.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/3/23
 */
public class TreeSetTest {
	
	public static void main(String[] args){
		Set<String> words = new TreeSet<String>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}});
		words.addAll(Arrays.asList(new String[]{"a", "d", "c", "c",}));
		System.out.println(words);

		System.out.println("1--------------------------");
		SortedSet<String> set2 = new TreeSet<String>();
		set2.addAll(Arrays.asList(new String[]{"c", "a", "b", "d","f"}));
		System.out.println(set2);
		System.out.println(set2.first()); //a
		System.out.println(set2.last()); //f
		System.out.println(set2.headSet("b"));//[a]
		System.out.println(set2.tailSet("d"));//[d, f]
		System.out.println(set2.subSet("b", "e")); //[b, c, d]
		set2.subSet("b", "e").clear(); //会从原set中删除
		System.out.println(set2); //[a, f]
	}
}
