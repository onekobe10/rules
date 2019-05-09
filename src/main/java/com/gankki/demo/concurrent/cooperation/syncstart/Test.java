package com.gankki.demo.concurrent.cooperation.syncstart;

/**
 *@desc 同时开始模拟
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Test {

	/**
	 * 先让每个启动的线程wait，然后在主线程中调用共享变量的notifyAll方法来达到同时开始所有线程的目的
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		int num = 10;
		FireFlag fireFlag = new FireFlag();
		Thread[] racers = new Thread[num];
		for (int i = 0; i < num; i++) {
			racers[i] = new Racer(fireFlag);
			racers[i].start();
		}
		Thread.sleep(3000);
		fireFlag.fire();
	}
}
