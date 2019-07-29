package com.gankki.demo.test.lambda.function;

import java.util.ArrayList;
import java.util.function.Function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/26
 */
public class FunctionTest {


	public static void main(String[] args){
		Function function = Object::hashCode;

		System.out.println(function.apply(new ArrayList<>()));
	}
}
