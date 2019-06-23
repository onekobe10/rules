package com.gankki.demo.designpattern.observer.section3;

/**
 *@desc 所有观察者，通用接口
 *@author liuhao
 *@createDate 2019/6/23
 */
public interface Observer {
	
	//一发现别人有动静，自己也要行动起来
	public void update(String context);  
}
