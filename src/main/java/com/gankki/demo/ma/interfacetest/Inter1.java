package com.gankki.demo.ma.interfacetest;

public interface Inter1 {

	@Override
	boolean equals(Object obj);

	String test1();
	String test2();

	default void test4() {
		System.out.println("test4..............");
	}
}
