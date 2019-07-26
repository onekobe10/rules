package com.gankki.demo.optimization.jvm.o1;

import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/16
 */
public class Test {
	public final List<String> t1 = Test2.test("final");
	public static final List<String> t2 = Test2.test("static final");

	{
		t1.add("1");
	}

	public static void main(String[] args){
	    Test test = new Test();
	    Test test2 = new Test();

	    System.out.println(test.t1.size());//  1
	    test.t1.add("2");
		System.out.println(test.t1.size());//  2
	    System.out.println(test2.t1.size());//  1
	}
}
