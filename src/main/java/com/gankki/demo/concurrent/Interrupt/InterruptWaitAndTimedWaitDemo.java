package com.gankki.demo.concurrent.Interrupt;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class InterruptWaitAndTimedWaitDemo{

	public static void main(String[] args){
		Thread t = new Thread (){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(isInterrupted());
				}
			}
		};
		t.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		t.interrupt();
	}

}
