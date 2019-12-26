package com.gankki.demo.test.Interface;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/27
 */
public interface InterfaceTest {

	String testPublic();

	static String testStatic(){
		return "hello world";
	}

	default void testDefault1(){
		System.out.println("default method test");
	}

	default void testDefault2(){
		testDefault1();
		System.out.println("default method test");
	}
}
