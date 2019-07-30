package com.gankki.demo.test.lambda.function;

import org.dom4j.tree.SingleIterator;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/26
 */
public class FunctionTest {


	public static void main(String[] args){
		Function function1 = Object::hashCode;
		System.out.println(function1.apply(new ArrayList<>()));

		// 输入参数为Object,所以可以不加泛型约束
		Function function2 = SingleIterator::new;

		Function<String, SingleFieldFunction> function4 = SingleFieldFunction::new;

		SingleFieldFunction s1 = function4.apply("haha");
		System.out.println(s1.getXxx());

		BiFunction<String, Integer, DoubleFieldFunction> biFunction = DoubleFieldFunction::new;
		DoubleFieldFunction d1 = biFunction.apply("name", 25);
		System.out.println(d1.getName() + "...." + d1.getAge());


	}
}
