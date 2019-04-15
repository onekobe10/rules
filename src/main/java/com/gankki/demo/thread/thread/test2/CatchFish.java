package com.gankki.demo.thread.thread.test2;

import java.util.ArrayList;
import java.util.List;

public class CatchFish implements Runnable {
	List<String> basket = new ArrayList<String>(50);

	@Override
	public void run() {
		int i = 0;
		while (true) {
			if (basket.size() > 30) {
				break;
			}
			basket.add("111");
			System.out.println(Thread.currentThread().getName() + "...222");

			try {
				Thread.currentThread().sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
