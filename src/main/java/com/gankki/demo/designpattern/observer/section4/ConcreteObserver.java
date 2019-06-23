package com.gankki.demo.designpattern.observer.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/23
 */
public class ConcreteObserver implements Observer {

	//实现更新方法
	@Override
	public void update() {
		System.out.println("接收到信息，并进行处理！");
	}

}
