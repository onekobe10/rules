package com.gankki.demo.designpattern.memento.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Caretaker {
	
	//备忘录对象
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
