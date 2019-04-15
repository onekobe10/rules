package com.gankki.demo.ma;

import java.util.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/2
 */
public class ContainerTest {

	public static void main(String[] args){
		List<Integer> list = Arrays.asList(new Integer[]{
				8, 5, 3, 6, 2, 19, 21
		});
		System.out.println(list.subList(1, 5));
		Collections.rotate(list.subList(1, 5), 2);
		System.out.println(list);

		List list2 = new ArrayList<Integer>();
		list2.add("hello");
		System.out.println(list2);

		Collection<String> coll = Collections.singleton("编程");
	}
}
