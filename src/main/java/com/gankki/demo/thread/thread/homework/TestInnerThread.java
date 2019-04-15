package com.gankki.demo.thread.thread.homework;

/**
 * 1. ���4���̣߳����������߳�ÿ�ζ�j����1�����������̶߳�jÿ�μ��� 1��Ҫ��ʹ���ڲ���ʵ���̣߳���j������ʱ�򲻿���˳�����⡣
 * 
 * @author Gankki
 */
public class TestInnerThread {

	public TestInnerThread() {
		super();
	}

	public class innerThread extends Thread {
		TestInnerTheadMethod ttt;
		public int index;

		public innerThread(TestInnerTheadMethod ttt, int index) {
			this.ttt = ttt;
			this.index = index;
		}
		
		@Override
		public void run() {

			synchronized (ttt) {
				ttt.choise(index);
			}
		}

	}
}
