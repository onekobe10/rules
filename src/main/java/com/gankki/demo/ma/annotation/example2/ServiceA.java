package com.gankki.demo.ma.annotation.example2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class ServiceA {

	@SimpleInject
	ServiceB b;

	public void callB(){
		b.action();
	}

	public ServiceB getB() {
		return b;
	}
}
