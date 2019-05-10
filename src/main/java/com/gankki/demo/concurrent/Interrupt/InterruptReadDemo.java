package com.gankki.demo.concurrent.Interrupt;

import java.io.IOException;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/10
 */
public class InterruptReadDemo {

	private static class A extends Thread {
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()){
				try {
					System.out.println(System.in.read());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("exit");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		A t = new A();
		t.start();
		Thread.sleep(100);

		t.interrupt();
	}
}
