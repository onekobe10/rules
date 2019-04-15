package com.gankki.demo.thread.thread.test5;

public class Test {
	public static void main(String[] args) {
		
		Mountaion mm = new Mountaion(200);
		Trainer tt1 = new Trainer(mm, 30);
		Trainer tt2 = new Trainer(mm, 50);
		Trainer tt3 = new Trainer(mm, 100);
		
		tt1.start();
		tt2.start();
		tt3.start();
	}
}
