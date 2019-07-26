package com.gankki.demo.ma.genericity.superextendstest;

import com.gankki.demo.ma.genericity.DynamicArray;
import com.gankki.demo.ma.genericity.superextendstest.B;
import com.gankki.demo.ma.genericity.superextendstest.C;
import com.gankki.demo.ma.genericity.superextendstest.D;
import org.apache.poi.hssf.record.formula.functions.T;

import java.util.function.Function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/24
 */
public class SuperTest {


	public static void main(String[] args){
		DynamicArray<Integer> ints = new DynamicArray<>();
		ints.add(100);
		ints.add(34);
		DynamicArray<Number> numbers = new DynamicArray<>();
		ints.copyTo(numbers);

		// --------------------Function super extends----------------
		Function<B, C> function = c -> new C();
		testFunction(function);
	}

	public static void testFunction(Function<? super C, ? extends B> function){
		function.apply(new D());
	}
}
