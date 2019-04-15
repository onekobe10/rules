package com.gankki.demo.thread.thread.deadlock;

public class Test {
	public static void main(String[] args) {
		String str1 = "nihao";
		String str2 = "world";
		A_Thread a_Thread = new A_Thread(str1, str2);
		B_Thread b_Thread = new B_Thread(str1, str2);
		
		Thread t1 = new Thread(a_Thread);
		Thread t2 = new Thread(b_Thread);
		
		t1.start();
		t2.start();
	}
}
