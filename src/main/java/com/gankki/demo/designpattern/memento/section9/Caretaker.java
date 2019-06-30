package com.gankki.demo.designpattern.memento.section9;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Caretaker {
	
	//备忘录对象
	private IMemento memento;

	public IMemento getMemento() {
		return memento;
	}

	public void setMemento(IMemento memento) {
		this.memento = memento;
	}
	
}
