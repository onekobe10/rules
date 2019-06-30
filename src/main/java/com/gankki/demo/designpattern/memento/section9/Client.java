package com.gankki.demo.designpattern.memento.section9;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Client {
	
	public static void main(String[] args) {
		//定义出发起人
		Originator originator = new Originator();
		//定义出备忘录管理员
		Caretaker caretaker = new Caretaker();
		//创建一个备忘录
		caretaker.setMemento(originator.createMemento());
		//恢复一个备忘录
		originator.restoreMemento(caretaker.getMemento());
	}
}
