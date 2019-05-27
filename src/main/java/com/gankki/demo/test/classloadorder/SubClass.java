package com.gankki.demo.test.classloadorder;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/27
 */
public class SubClass extends SuperObject{
	public SubClass() {
		System.out.println("子类的构造方法");
	}

	{
		System.out.println("子类的普通代码块");
	}

	static {
		System.out.println("子类的静态的代码块");
	}


	public static void main(String[] args){
	    SubClass subClass1 = new SubClass();

	    System.out.println(".............");

		SubClass subClass2 = new SubClass();
	}

}
