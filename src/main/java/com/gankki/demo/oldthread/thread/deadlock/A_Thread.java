package com.gankki.demo.oldthread.thread.deadlock;
public class A_Thread implements Runnable{
	public String str1;
	public String str2;
	
	public A_Thread(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	@Override
	public void run() {
		synchronized (str1) {
			System.out.println("aaaaaaaaaaaa.........");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (str2) {
				System.out.println("bbbb++++++++++++++");
			}
		}
		
	}
	
}
