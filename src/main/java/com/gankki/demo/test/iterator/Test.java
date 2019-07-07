package com.gankki.demo.test.iterator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/7
 */
public class Test {

	public static void main(String[] args){
		List<String> list = Arrays.asList("1","2","3","4","5");
		Consumer<String> consumer1 = t -> System.out.println(t);
		// lambda 的写法
		list.iterator().forEachRemaining(consumer1);
		// 未知的写法
		list.iterator().forEachRemaining(System.out::println);
	}
}
