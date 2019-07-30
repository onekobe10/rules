package com.gankki.demo.test.lambda.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/4
 */
public class ConsumerTest {
	
	public static void main(String[] args){
		// 1.
		Consumer<String> c1 = t -> System.out.println(t + "		c1");
		Consumer<String> c2 = t -> System.out.println(t + "		c2");
		Consumer<String> c3 = t -> System.out.println(t + "		c3");
		Consumer<String> c4 = System.out::println;

		c1.andThen(c2).andThen(c3).accept("hello");
		
		System.out.println("...........1............");

		// 2.
		// 2.1 接收一个参数
		Student s = new Student();
		Consumer<String> consumer1 = s::setName;
		Consumer<Integer> consumer2 = s::setAge;
		consumer1.accept("liuhao");
		consumer2.accept(25);
		System.out.println(s.getName() + "...." + s.getAge());

		// 2.2  接收两个参数
		Student s2 = new Student();
		BiConsumer<Student, String> bi1 = Student::setName;
		bi1.accept(s2, "liuhao");
		System.out.println(s2.getName() + "...");

		StringBuilder s1 = new StringBuilder("123456");
		System.out.println(s1.substring(3));
		System.out.println(s1);
		BiConsumer<StringBuilder, Integer> bi2 = StringBuilder::substring;
		bi2.accept(s1, 3);
		System.out.println(s1);

		System.out.println("...........2............");

	}
}
