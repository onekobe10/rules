package com.gankki.demo.ma.interfacetest;

@FunctionalInterface
public interface Inter2 {
	String test1();
	@Override
	boolean equals(Object obj);
	@Override
	int hashCode();
	@Override
	String toString();

	//Object clone();
	/*default void test4() {
		System.out.println("test4..............");
	}*/
}
