package com.gankki.demo.designpattern.memento.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Memento {
	
	//发起人的内部状态
	private String state = "";
	
	//构造函数传递参数
	public Memento(String _state){
		this.state = _state;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
