package com.gankki.demo.oldthread.thread.test2;

public class Test {
	public static void main(String[] args) {

		MakeWater mWater = new MakeWater();
		Thread threadWater = new Thread(mWater);
		threadWater.start();

		CatchFish cFish1 = new CatchFish();
		Thread thread2 = new Thread(cFish1);
		Thread thread3 = new Thread(cFish1);
		Thread thread4 = new Thread(cFish1);
		thread2.start();
		thread3.start();
		thread4.start();

		try {
			threadWater.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1111111111");
	}
}
