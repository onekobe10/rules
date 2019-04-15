package com.gankki.demo.thread.thread.homework;

public class Test {
	public static void main(String[] args) {
		TestInnerTheadMethod titm = new TestInnerTheadMethod(0);
		TestInnerThread ttt = new TestInnerThread();
		TestInnerThread.innerThread  innerThread1 = ttt.new innerThread(titm,0);
		TestInnerThread.innerThread  innerThread2 = ttt.new innerThread(titm, 1);
		TestInnerThread.innerThread  innerThread3 = ttt.new innerThread(titm, 0);
		TestInnerThread.innerThread  innerThread4 = ttt.new innerThread(titm, 0);
		innerThread1.start();
		innerThread2.start();
		innerThread3.start();
		innerThread4.start();
	}
}
