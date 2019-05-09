package com.gankki.demo.concurrent.cooperation.syncstart;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Racer extends Thread {
	FireFlag fireFlag;

	public Racer(FireFlag fireFlag) {
		this.fireFlag = fireFlag;
	}

	@Override
	public void run() {
		try {
			this.fireFlag.waitForFire();
			System.out.println("start run "
					+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
		}
	}
}
