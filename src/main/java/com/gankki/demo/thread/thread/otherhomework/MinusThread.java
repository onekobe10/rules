package com.gankki.demo.thread.thread.otherhomework;

public class MinusThread {

	public class InnerMinus extends Thread {
		ShareThread st;

		public InnerMinus(ShareThread st) {
			super();
			this.st = st;
		}

		@Override
		public void run() {
			synchronized (st) {
				while (true) {
					try {
						st.notifyAll();
						st.minus();
						st.wait();
						if (st.getJ() > 10) {
							break;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
