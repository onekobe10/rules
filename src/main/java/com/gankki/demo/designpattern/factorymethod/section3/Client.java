package com.gankki.demo.designpattern.factorymethod.section3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/18
 */
public class Client {
	public static void main(String[] args) {
		SingletonFactory.getSingleton().doSomething();
	}
}
