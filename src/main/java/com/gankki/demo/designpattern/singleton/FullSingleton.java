package com.gankki.demo.designpattern.singleton;

/**
 *@des 饱汉单例，类加载的时候完成实例化
 *@author liuhao
 *@createDate 2019/5/16
 */
public class FullSingleton {

	private static  final FullSingleton  FULL_SINGLETON = new FullSingleton();

	/**
	 * private修饰，避免被其他类实例化。
	 */
	private FullSingleton(){

	}

	public  static FullSingleton getInstance(){
		return FULL_SINGLETON;
	}
}
