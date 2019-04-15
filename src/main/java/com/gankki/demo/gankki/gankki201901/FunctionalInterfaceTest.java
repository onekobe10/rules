package com.gankki.demo.gankki.gankki201901;

public interface FunctionalInterfaceTest {

	void test(String test);

	/**
	 * 默认方法
	 */
	default void testDefault(){
		System.out.println("测试接口内部的默认方法");
	}
	static void  testStatic(){
		System.out.println("测试静态方法");
	}
}
