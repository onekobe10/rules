package com.gankki.demo.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
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
		// list.stream().forEach(System.out::println);

		System.out.println("....................1...................");

		List<StreamBean> streamBeanList = new ArrayList<>();
		StreamBean s1 = new StreamBean("liuhao1", 25);
		StreamBean s2 = new StreamBean("liuhao2", 26);
		StreamBean s3 = new StreamBean("liuhao3", 27);
		streamBeanList.add(s1);
		streamBeanList.add(s2);
		streamBeanList.add(s3);

		// foreach
		// streamBeanList = null; // java.lang.NullPointerException
		streamBeanList.parallelStream().forEach(streamBean -> {
			System.out.println(streamBean.getUserName() + "..." + streamBean.getAge());
		});



	}
}
