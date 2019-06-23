package com.gankki.demo.designpattern.observer.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/23
 */
public class ConcreteSubject extends Subject {
	
	//具体的业务
	public void doSomething(){
		/*
		 * do something
		 */
		super.notifyObserver();
	}
}
