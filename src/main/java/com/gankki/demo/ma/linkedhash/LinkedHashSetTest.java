package com.gankki.demo.ma.linkedhash;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/1
 */
public class LinkedHashSetTest {


	public static void main(String[] args){
		Set<String> set = new LinkedHashSet<>();
		set.add("b");
		set.add("c");
		set.add("a");
		set.add("c");

		System.out.println(set);
	}
}
