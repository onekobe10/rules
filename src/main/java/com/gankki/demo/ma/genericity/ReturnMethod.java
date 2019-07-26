package com.gankki.demo.ma.genericity;

import org.apache.poi.hssf.record.formula.functions.T;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.Map;
import java.util.stream.Collector;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/24
 */
public class ReturnMethod {


	<K, U> Collector<T, ?, Map<K, U>> testMethod1(
					Function<? super T, ? extends K> a,
					Function<? super T, ? extends U> b){
		return null;
	}

	<K, U, M, N> Collector<T, ?, Map<K, U>> testMethod2(
			Function<? super T, ? extends K> a,
			Function<? super T, ? extends U> b){
		return null;
	}

	public static void main(String[] args){
		List<String> list = Arrays.asList("1", "2", "3");
		list.stream().forEach(System.out::println);
	}
}
