package com.gankki.demo.thread.thread.deadlock;

public class B_Thread implements Runnable{
	public String str1;
	public String str2;
	
	public B_Thread(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
	}
	@Override
	public void run() {
		synchronized (str2) {
			System.out.println("cccccccccccccc++++++++");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(str1){
				System.out.println("dddddddddddd++++++++++++");
			}
		}
		
	}
	
}
