package com.gankki.demo.designpattern.singleton;

/**
 *@desc 饥汉单例，在第一次使用的时候创建单例。如果不加锁，并发状态下可能会创建多个对象
 *@author liuhao
 *@createDate 2019/5/16
 */
public class HungrySingleton {

	private static HungrySingleton singleton = null;

	private HungrySingleton(){

	}

	public synchronized static HungrySingleton getInstance() {
		if (singleton == null) {
			singleton = new HungrySingleton();
		}
		return singleton;
	}

}
