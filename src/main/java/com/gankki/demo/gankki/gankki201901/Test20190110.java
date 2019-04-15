package com.gankki.demo.gankki.gankki201901;

public class Test20190110 {


	public static void main(String[] args){
	  FunctionalInterfaceTest fit = (t) -> System.out.println(t);
	  fit.test("哈哈");
	  fit.testDefault();
	  FunctionalInterfaceTest.testStatic();
	}
}
