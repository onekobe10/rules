package com.gankki.demo.thread.thread.homework;

public class LetterPrinter extends Thread {
	private Printer p;

	public LetterPrinter(Printer p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			// for (char i = 'A'; i <= 'Z'; i++) {
			char i = 'A';
			while (true) {
				if (i <= 'Z') {
					p.printCase(i);
					p.notify();
					if (p.index % 3 != 0) {
						try {
							if (i == 'Z') {
								break;
							}
							p.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				i++;
			}
		}
	}
}
