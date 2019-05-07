package com.gankki.demo.oldthread.thread.homework;

public class TestInnerTheadMethod {
	
	private int i;
	
	public TestInnerTheadMethod() {
		super();
	}
	
	public TestInnerTheadMethod(int i) {
		super();
		this.i = i;
	}
	
	public void choise(int i){
		if(i  == 1){
			add();
		}
		if(i == 0){
			minus();
		}
	}
	public void add(){
		this.i++;
		System.out.println(i);
	}
	public void minus(){
		this.i--;
		System.out.println(i);
	}
}
