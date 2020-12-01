package com.gankki.demo.designpattern.singleton;

/**
 *@desc 双检锁
 *@author liuhao
 *@createDate 2019/5/27
 */
public class Singleton {
	private static Singleton singleton = null;

	private Singleton() {
	}

	public static Singleton getSingleton() {// 不要把 synchronized 加到方法上，影响性能。
		// 尽量避免重复进入同步块
		if (singleton == null) {
			// 同步.class，意味着对同步类方法调用
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}

