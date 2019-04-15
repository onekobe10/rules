package com.gankki.demo.thread.thread.homework;

public class Printer {
	public int index = 1;

	public void printNumber(int i) {
		if (index % 3 != 0) {
			System.out.print(i);
			index++;
		}
	}

	public void printCase(char c) {
		if (index % 3 == 0) {
			System.out.print(c);
			index++;
		}
	}

}
