package com.gankki.demo.oldthread.thread.homework;

public class LetterPrinter2 extends Thread {
	private Printer p;

	public LetterPrinter2(Printer p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			for (char i = 'A'; i <= 'Z'; i++) {
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

		}
	}
}
