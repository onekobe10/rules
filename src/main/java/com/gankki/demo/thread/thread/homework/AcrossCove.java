package com.gankki.demo.thread.thread.homework;

/**
 * 2.��д���̳߳���ģ������ͨ��һ��ɽ����ģ�⡣���ɽ��ÿ��ֻ��ͨ��һ����
 * ÿ����ͨ��ɽ����ʱ��Ϊ5�룬��10����ͬʱ׼������ɽ������ʾÿ��ͨ��ɽ���˵�������˳��
 * 
 * @author Gankki
 *
 * 
 */
public class AcrossCove {
	public static void main(String[] args) {
		Cove  cove = new Cove("����ɽ", 200);
		Someone s1 = new Someone("С��1", 30, cove);
		Someone s2 = new Someone("С��2", 40, cove);
		Someone s3 = new Someone("С��3", 50, cove);
		Someone s4 = new Someone("С��4", 60, cove);
		Someone s5 = new Someone("С��5", 70, cove);
		
		Thread thread1 = new Thread(s1);
		Thread thread2 = new Thread(s2);
		Thread thread3 = new Thread(s3);
		Thread thread4 = new Thread(s4);
		Thread thread5 = new Thread(s5);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
