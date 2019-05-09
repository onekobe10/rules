package com.gankki.demo.concurrent.cooperation.waitend;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Test {
	
	public static void main(String[] args) throws Exception{
		int workerNum = 20;
		MyLatch latch = new MyLatch(workerNum);
		Worker[] workers = new Worker[workerNum];
		for (int i = 0; i < workerNum; i++) {
			workers[i] = new Worker(latch);
			workers[i].start();
		}
		latch.await();

		System.out.println("collect worker results");
	}
}
