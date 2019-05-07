package com.gankki.demo.oldthread.thread.test;

public class Person {
   public String name;
   
   public Person(String name) {
	super();
	this.name = name;
}

public Person() {
	super();
	// TODO Auto-generated constructor stub
}

private void eat(){
	   System.out.println("�Է�");
   }
public void run(){
	System.out.println("�ܲ�");
}
}
