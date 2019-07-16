package com.gankki.demo.ma.classtest.extend;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/16
 */
public class Child extends Base {

	@Override
	public Integer sum(int sa, int b){
		System.out.println("child_long_long");
		return sa+b;
	}

	public static void main(String[] args){
		Child c = new Child();
		int a = 2;
		int b = 3;
		c.sum(a, b);
	}
}
