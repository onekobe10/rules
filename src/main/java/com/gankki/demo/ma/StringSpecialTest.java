package com.gankki.demo.ma;

public class StringSpecialTest {
	
	
	public static void main(String[] args){
		String hello = "hello";
		hello+=",world";
		System.out.println(hello);

		System.out.println("----------------");

		String hello2 = "hell2o";
		for(int i=0; i < 3; i++){
			hello2 += ",world";
		}
		System.out.println(hello2);
	}
}
