package com.gankki.demo.oldthread.thread.homework;

public class NumberPrinter2 extends Thread {
	private Printer p;

	public NumberPrinter2(Printer p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			for (int i = 1; i < 53; i++) {
				p.printNumber(i);
				p.notify();

				if (p.index % 3 == 0) {
					try {
						if (i == 52) {
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
