package com.gankki.demo.concurrent.cooperation.assemblepoint;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class AssemblePoint {
	private int n;

	public AssemblePoint(int n) {
		this.n = n;
	}

	public synchronized void await() throws InterruptedException {
		if (n > 0) {
			n--;
			if (n == 0) {
				notifyAll();
			} else {
				while (n != 0) {
					wait();
				}
			}
		}
	}
}
