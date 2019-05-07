package com.gankki.demo.oldthread.thread.test;

public class FirstThread extends Thread {

	@Override
	public void run() {
		for (int i = 1;i<20; i++) {
			System.out.println(this.getName() + "haha ");
		}
	}
	
	public static void main(String[] args) {
		FirstThread ft = new FirstThread();
		ft.start();
		for(int i=0;i<30;i++){
            System.out.println("main-->"+i);
        }
	}
}
