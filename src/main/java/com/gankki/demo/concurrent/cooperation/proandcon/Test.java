package com.gankki.demo.concurrent.cooperation.proandcon;

import com.gankki.demo.concurrent.cooperation.proandcon.Consumer;
import com.gankki.demo.concurrent.cooperation.proandcon.MyBlockingQueue;
import com.gankki.demo.concurrent.cooperation.proandcon.Producer;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Test {
	
	public static void main(String[] args){
		MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);
		new Producer(queue).start();
		new Consumer(queue).start();
	}
}
