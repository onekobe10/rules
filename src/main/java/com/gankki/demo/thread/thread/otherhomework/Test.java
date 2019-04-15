package com.gankki.demo.thread.thread.otherhomework;

/**
 * 1.	���4���̣߳����������߳�ÿ�ζ�j����1�����������̶߳�jÿ�μ���1��
 * 		Ҫ��ʹ���ڲ���ʵ���̣߳���j������ʱ�򲻿���˳�����⡣
 * @author Gankki
 *
 * 
 */
public class Test {
	public static void main(String[] args) {
		
		ShareThread st = new ShareThread(5);
		AddThread.InnerAdd innerAdd = new AddThread().new InnerAdd(st);
		MinusThread.InnerMinus innerMinus = new MinusThread().new InnerMinus(st);
		AddThread.InnerAdd innerAdd2 = new AddThread().new InnerAdd(st);
		MinusThread.InnerMinus innerMinus2 = new MinusThread().new InnerMinus(st);
		
		innerAdd.start();
		innerMinus.start();
		innerAdd2.start();
		innerMinus2.start();
	}
}
