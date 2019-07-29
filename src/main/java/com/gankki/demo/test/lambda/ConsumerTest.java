package com.gankki.demo.test.lambda;

import java.util.function.Consumer;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/4
 */
public class ConsumerTest {
	
	
	public static void main(String[] args){
		Consumer<String> c1 = t -> System.out.println(t + "		c1");
		Consumer<String> c2 = t -> System.out.println(t + "		c2");
		Consumer<String> c3 = t -> System.out.println(t + "		c3");
		Consumer<String> c4 = System.out::println;

		c1.andThen(c2).andThen(c3).accept("hello");
	}
}
