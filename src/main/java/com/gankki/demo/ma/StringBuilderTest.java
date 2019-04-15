package com.gankki.demo.ma;

public class StringBuilderTest {

	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.append("老马说编程");
		sb.insert(0, "关注");
		sb.insert(sb.length(), "老马和你一起探索编程本质");
		sb.insert(7, ",");
		System.out.println(sb.toString());

		StringBuilder sb2 = new StringBuilder();
		sb2.append("老马说编程");
		sb2.replace(3, 5, "Java");
		System.out.println(sb2.toString());

		System.out.println(sb2.length());
		System.out.println(sb2.capacity());
		sb.setLength(1);
		sb.trimToSize();
		sb.subSequence(0, 1);


		String hello = "hello";
		for(int i=0;i<3;i++){
			hello+=",world";
		}
		System.out.println(hello);

	}
}
