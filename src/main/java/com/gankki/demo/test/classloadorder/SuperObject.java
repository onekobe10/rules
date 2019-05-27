package com.gankki.demo.test.classloadorder;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/27
 */
public class SuperObject {

	public SuperObject() {
		super();
		System.out.println("父类的构造方法");
	}

	static {
		System.out.println("父类的静态的代码块");
	}

	{
		System.out.println("父类的普通代码块");
	}
}
