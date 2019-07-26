package com.gankki.demo.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/24
 */
public class foreachtest<T> {

	<A, B> B testMethod(Function<? super T, ? extends B> a, Function<? super T, ? extends B> b,
						Function<? super A, ? extends B> c){
		return null;
	}

	public static void main(String[] args){
		List<String> list = Arrays.asList("1", "2", "3");
		list.stream().forEach(System.out::println);
	}
}
