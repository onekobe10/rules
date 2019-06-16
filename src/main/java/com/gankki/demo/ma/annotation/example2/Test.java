package com.gankki.demo.ma.annotation.example2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class Test {


	public static void main(String[] args){
		ServiceA a = SimpleContainer2.getInstance(ServiceA.class);
		a.callB();
	}
}
