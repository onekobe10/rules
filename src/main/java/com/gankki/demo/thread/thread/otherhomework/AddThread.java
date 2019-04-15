package com.gankki.demo.thread.thread.otherhomework;

public class AddThread {

	public class InnerAdd extends Thread{
		ShareThread st;
		
		public InnerAdd(ShareThread st) {
			super();
			this.st = st;
		}

		@Override
		public void run() {
			
			synchronized (st) {
				while(true){
					st.notifyAll();
					st.add();
					try{
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
