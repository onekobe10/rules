package com.gankki.demo.ma.interfacetest;

import java.util.ArrayList;

public class TestInterface implements Inter1,Inter2 {
	@Override
	public String test1() {
		return null;
	}

	@Override
	public String test2() {
		return null;
	}

	public static void main(String[] args){
	    // 多个接口中有多个相同抽象方法时，不会报错,因为抽象方法一定会在实现类中实现
		// 多个接口中有多个相同的默认方法时，如果不在实现类中重写一定会报错
		Iterable<String> list = new ArrayList<>();
		list.toString();
	}
}

