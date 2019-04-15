package com.gankki.demo.thread.thread.test2;

public class MakeWater implements Runnable {

	@Override
	public void  run() {
		int i = 0;

		for (i = 0; i < 7; i++) {
			System.out.println("333");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
