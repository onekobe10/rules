package com.gankki.demo.thread.thread.test3;

public class TT implements Runnable{
	int b = 100;
	
	public synchronized void m1() throws Exception{
		b = 1000;
		Thread.sleep(5000);
		System.out.println("b = " + b);
	}
	public void m2(){
		System.out.println(b);
	}
	@Override
	public void run() {
		try{
			m1();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		TT tt = new TT();
		Thread t = new Thread(tt);
		t.start();
		
		Thread.sleep(1000);
		tt.m2();
	}
	
}
