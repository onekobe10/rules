package com.gankki.demo.ma.genericity;

public class TestGeneric<E> {

	public TestGeneric(){
		super();
	}
	
	
	public static void main(String[] args) {
		System.out.println("111");
		test();
		System.out.println("222");
		System.out.println("333");
	}

	public static void test(){
		for (int i=0;i<200;i++) {
			System.out.println("sss");
		}
		System.out.println("aa");
	}
}
