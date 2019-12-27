package com.gankki.demo.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *@desc 双冒号的使用
 *@author liuhao
 *@createDate 2019/7/24
 */
public class DoubleColon {

	public static void printStr(String str) {
		System.out.println("printStr : " + str);
	}

	public void toUpper(){
		System.out.println("toUpper : " + this.toString());
	}

	public void toLower(String str){
		System.out.println("toLower : " + str);
	}

	public int toInt(String str){
		System.out.println("toInt : " + str);
		return 1;
	}
	
	/**
	 * 1. 方法引用
	 * 类名::方法名
	 * 2. 构造方法
	 * 类名::new
	 *
	 * 用::提取的函数，最主要的区别在于静态与非静态方法，非静态方法比静态方法多一个参数，就是被调用的实例。
	 *
	 * :: 是一种语法糖，后面跟的方法入参为空，或者只能有一个入参。
	 * 根据入参的不同选择 Consumer BiConsumer
	 * bisexual; 双性恋的; 双性恋者;
	 *
	 */
	public static void main(String[] args){
		Consumer<String> printStrConsumer = DoubleColon::printStr;
		printStrConsumer.accept("printStrConsumer");

		Consumer<DoubleColon> toUpperConsumer = DoubleColon::toUpper;
		toUpperConsumer.accept(new DoubleColon());

		// 非静态方法的第一个参数为被调用的对象，后面是入参
		BiConsumer<DoubleColon,String> toLowerConsumer = DoubleColon::toLower;
		toLowerConsumer.accept(new DoubleColon(),"toLowerConsumer");

		//Function<DoubleColon, String> function = DoubleColon::toInt;

		BiFunction<DoubleColon,String,Integer> toIntFunction = DoubleColon::toInt;
		int i = toIntFunction.apply(new DoubleColon(),"toInt");

		List<String> collected = new ArrayList<>();
		collected.add("alpha");
		collected.add("beta");
		collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化
		System.out.println(collected);
	}
}
