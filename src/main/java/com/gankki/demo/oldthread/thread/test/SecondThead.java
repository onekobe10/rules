package com.gankki.demo.oldthread.thread.test;

public class SecondThead implements Runnable {

	@Override
	public void run() {
		for (int i = 0;; i++) {
			if (i % 1000000000 == 0) {
				System.out.println(Thread.currentThread().getName() + "...111");
			}
		}
	}
	
	
	public static void main(String[] args) {
		SecondThead st = new SecondThead();
		Thread t = new Thread(st);
		t.start();
		for(int i=0;i<30;i++){
            System.out.println("main-->"+i);
        }
		
	}
}